package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import po.TransPO;

public class Transdocu extends Document {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	/**
	 * 建立装车单
	 * 
	 * @param TransPO tpo
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildTransDocu(TransPO tpo) {
		IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("HallClerk");
			oos.writeUTF("LoadingList");
			oos.writeObject(tpo);
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
