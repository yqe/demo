package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import po.CostManagePO;
import po.EarnedPO;

public class Earneddocu extends DocumentBl {

	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	/**
	 * 得到所给日期之间的所有收款单
	 * 如果是按ID查询 那么data1=="ID",则datar就是营业厅text的值;为得到所给营业厅ID的所有收款单
	 * 如果是按日期查询 那么data1=="day",则datar就是所选择的日期,为得到所给日期当天的所有收款单;
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<EarnedPO> GetEarnedDocu(String datal, String datar) {
		ArrayList<EarnedPO> epolist = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Finance");
			oos.writeUTF("GetEarnedDocu");
			oos.writeObject(new String(datal + " " + datar));
			epolist = (ArrayList<EarnedPO>) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return epolist;
	}

	/**
	 * 建立收款单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildEarnedDocu(EarnedPO earnpo) {
		IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("HallClerk");
			oos.writeUTF("ReceiveBill");
			oos.writeObject(earnpo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
