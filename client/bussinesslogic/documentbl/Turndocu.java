package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.TransPO;

public class Turndocu extends Document{
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";
	/**
	 * 建立装运单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildTurnDocu(TransPO tspo){
		IsOk = false;
	try {
		socket = new Socket(hostid, 8888);
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		oos.writeUTF("Transit");
		oos.writeUTF("ShipmentBill");
		oos.writeObject(tspo);
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
