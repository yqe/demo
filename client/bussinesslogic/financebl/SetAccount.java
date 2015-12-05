package financebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.InitializeAccountPO;

public class SetAccount {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";
	/**
	 * 建立期初建账
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
   public boolean BuildAccount(InitializeAccountPO apo){
		IsOk = false;
	try {
		socket = new Socket(hostid, 8888);
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		oos.writeUTF("Finance");
		//todo
		oos.writeUTF("ShipmentBill");
		oos.writeObject(apo);
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
