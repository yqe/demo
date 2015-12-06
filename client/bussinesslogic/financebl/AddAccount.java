package financebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.ManageAccountPO;

public class AddAccount {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";
	/**
	 * 建立增加账户
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildAddAccount(ManageAccountPO mpo){
		 IsOk = false;
			try {
				socket = new Socket(hostid, 8888);
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				oos.writeUTF("Finance");
				//todo
				oos.writeUTF("PaymentBill");
				oos.writeObject(mpo);
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
