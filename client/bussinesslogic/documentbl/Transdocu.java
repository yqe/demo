package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import po.TransPO;

public class Transdocu {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	public Transdocu(ObjectOutputStream oos, ObjectInputStream ois) {
		this.ois=ois;
		this.oos=oos;
	}

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
			oos.writeUTF("HallClerk");
			oos.writeUTF("LoadingList");
			oos.writeObject(tpo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
