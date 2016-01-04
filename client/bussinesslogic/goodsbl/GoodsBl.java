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
import po.ExpressTrailPO;
import po.GoodsDocuPO;

public class GoodsBl implements GoodsBLService {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;

	public GoodsBl(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos = oos;
		this.ois = ois;
	}

	/**
	 * 返回寄件单号
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public String GetExpressID() {
		String reid = null;
		try {
			oos.writeUTF("Courier");
			oos.writeUTF("GetExpressID");
			oos.writeObject(new String("OK"));
			reid = (String) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reid;
	}

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
			oos.writeUTF("Courier");
			oos.writeUTF("SendBill");
			oos.writeObject(gdpo);
			IsOk = (boolean) ois.readObject();
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
		String route = null;
		try {
			oos.writeObject(new String("GetRoute"));
			oos.writeObject(new String(ID));
			ExpressTrailPO routepo = (ExpressTrailPO) ois.readObject();
			route = routepo.getDepar() + "\n"+routepo.getBusstrail() + "\n"+ routepo.getCentertrail() +  "\n"+routepo.getDestination();
			route.replaceAll(null, "");
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
			oos.writeUTF("Courier");
			oos.writeUTF("QueryOrder");
			oos.writeObject(new String(ID));
			GoodsDocuPO gdpo = (GoodsDocuPO) ois.readObject();
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

	// String[] type=new String[]{"普通快递","经济快递","次晨特快"};
	// double[] typeprice=new double[]{23.0,18.0,25.0};
	// String[] pack=new String[]{"纸箱(5元)","木箱(10元)","快递袋(1元)"};
	// double[] packprice=new double[]{5.0,10.0,1.0};
	public String Goodsgetfee(Double weight, String typebox, String packbox, String depatureplace, String destination) {
		String priceStr = "";
		try {
			oos.writeUTF("Courier");
			oos.writeUTF("AboutPrice");
			oos.writeObject(new String(depatureplace + " " + destination));
			double discon = (double) ois.readObject();
			// System.out.println(discon);
			double i = 0, j = 0;
			if (typebox.equals("普通快递")) {
				i = 23.0;
			} else if (typebox.equals("经济快递")) {
				i = 18.0;
			} else {
				i = 25.0;
			}

			if (packbox.equals("纸箱(5元)")) {
				j = 5.0;
			} else if (packbox.equals("木箱(10元)")) {
				j = 10.0;
			} else {
				j = 1.0;
			}
			// System.out.println(i);
			// System.out.println(j);
			// System.out.println(discon);
			double price = i * (weight * discon) / 30000 + j;
			System.out.println(price);
			priceStr = price + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceStr;
	}

	// 显示快件的预计到达日期
	public String Goodsgetdate(String depatureplace, String destination, String typebox) {
		String re = null;
		try {
			System.out.println(typebox);
			oos.writeUTF("Courier");
			oos.writeUTF("GetArrivalDay");
			oos.writeObject(new String(depatureplace + " " + destination + " " + typebox));
			re = (String) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

}
