package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Yytarrivaldocu extends Document {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	/**
	 * 建立营业厅到达单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildHallArrivalDocu() {
		IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("InStoragePO");
			oos.writeObject("");
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
