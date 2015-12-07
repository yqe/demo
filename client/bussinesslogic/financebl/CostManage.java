package financebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import po.CostManagePO;

public class CostManage {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	/**
	 * 得到所给日期之间的所有收款单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<CostManagePO> GetCostManageDocu(String datal, String datar) {
		ArrayList<CostManagePO> cpolist = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Finance");
			oos.writeUTF("GetCostManageDocu");
			oos.writeObject(new String(datal + " " + datar));
			cpolist = (ArrayList<CostManagePO>) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpolist;
	}

	/**
	 * 建立成本管理
	 * 
	 * @param CostManagePO
	 *            cmpo
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildCostManage(CostManagePO cmpo) {
		IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Finance");
			oos.writeUTF("PaymentBill");
			oos.writeObject(cmpo);
			IsOk = ois.readBoolean();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
