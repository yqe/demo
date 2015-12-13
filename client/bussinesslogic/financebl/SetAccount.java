package financebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.InitializeAccountPO;

public class SetAccount {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;

	public SetAccount(ObjectOutputStream oos,ObjectInputStream ois) {
		this.oos=oos;
		this.ois=ois;
	}

	/**
	 * 建立期初建账
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildAccount(InitializeAccountPO apo) {
		IsOk = false;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("ShipmentBill");
			oos.writeObject(apo);
			IsOk = ois.readBoolean();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
