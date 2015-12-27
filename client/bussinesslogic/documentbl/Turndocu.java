package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.TransferDocuPO;

public class Turndocu {

	ObjectOutputStream oos;
	ObjectInputStream ois;

	public Turndocu(ObjectOutputStream oos, ObjectInputStream ois) {
		this.ois = ois;
		this.oos = oos;
	}

	/**
	 * 建立装运单
	 * 
	 * @param TransferDocuPO
	 *            tspo
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildTurnDocu(TransferDocuPO tspo) {
		boolean IsOk = false;
		try {
			oos.writeUTF("Transit");
			oos.writeUTF("ShipmentBill");
			oos.writeObject(tspo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;

	}
}
