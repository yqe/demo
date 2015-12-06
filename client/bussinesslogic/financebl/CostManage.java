package financebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.CostManagePO;

public class CostManage {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";
	/**
	 * 建立成本管理
	 * 
	 * @param CostManagePO cmpo
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
 public boolean BuildCostManage(CostManagePO cmpo){
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
