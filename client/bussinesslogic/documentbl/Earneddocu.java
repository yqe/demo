package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.EarnedPO;

public class Earneddocu extends Document {

	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

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
			oos.writeUTF("Storage");
			oos.writeUTF("InStoragePO");
			oos.writeObject(earnpo);
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
