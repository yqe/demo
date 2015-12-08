/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package goodsbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import goodsblService.GoodsBLService;
import po.GoodsDocuPO;

public class GoodsBl implements GoodsBLService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	/**
	 * 建立寄件单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildGoodsDocu(GoodsDocuPO gdpo) {
		IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Courier");
			oos.writeUTF("SendBill");
			oos.writeObject(gdpo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	/**
	 * 显示该ID快件的物流信息 客户使用
	 * 
	 * @param String
	 *            ID;
	 * @return String;
	 * @exception @author
	 *                zxc
	 */
	public String GoodsInquiry(String ID) {
		String route = "";
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Courier");
			oos.writeUTF("GetRoute");
			oos.writeObject(new String(ID));
			route = (String) ois.readObject();
			ois.close();
			oos.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return route;
	}

	/**
	 * 显示该ID快件的托运信息（收件人姓名，电话等） 快递员使用
	 * 
	 * @param String
	 *            ID;
	 * @return String[];
	 * @exception @author
	 *                zxc
	 */
	public String[] Goodsgetinfo(String ID) {
		String[] re = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Courier");
			oos.writeUTF("QueryOrder");
			oos.writeObject(new String(ID));
			GoodsDocuPO gdpo = (GoodsDocuPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
			re = new String[] { gdpo.getReceivername(), gdpo.getReceiveraddress(), gdpo.getReceiverworkspace(),
					gdpo.getReceivermobile() };
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	/**
	 * 显示快件的运费
	 * 
	 * @param String
	 *            ID;
	 * @return String;
	 * @exception @author
	 *                zxc
	 */
	String[] type=new String[]{"纸箱","木箱","快递袋"};
	double[] typeprice=new double[]{5.0,10.0,1.0};
	public String Goodsgetfee(Double weight, String type, String depatureplace, String destination) {
		String priceStr = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Courier");
			oos.writeUTF("AboutPrice");
			oos.writeObject(new String(depatureplace + " " + destination));
			double[] discon = (double[]) ois.readObject();
			double price = weight * discon[0] * discon[1]*typeprice[type.indexOf(type)];
			priceStr=price+"";
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceStr;
	}

	// 显示快件的预计到达日期
	public String Goodsgetdate(String depatureplace, String destination) {
		return destination;
	}
}
