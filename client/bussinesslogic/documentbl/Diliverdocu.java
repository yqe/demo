package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.DiliverDocuPO;

public class Diliverdocu {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;

	public Diliverdocu(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos = oos;
		this.ois = ois;
	}

	/**
	 * 建立派件单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildDiliverDocu(DiliverDocuPO ddpo) {
		IsOk = false;
		System.out.println(ddpo.getCourier());
		try {
			oos.writeUTF("Courier");
			oos.writeUTF("DeliveryBill");
			oos.writeObject(ddpo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;

	}
}
