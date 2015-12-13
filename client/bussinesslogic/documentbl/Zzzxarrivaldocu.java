package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.ZzzxArrivalDocuPO;

public class Zzzxarrivaldocu extends DocumentBl {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public Zzzxarrivaldocu(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos=oos;
		this.ois=ois;
	}
	/**
	 * 建立中转中心到达单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildZzzxarrivalDocu(ZzzxArrivalDocuPO zzzxpo){
		boolean IsOk = false;
		try {
			oos.writeUTF("Transit");
			oos.writeUTF("TransitReceive");
			oos.writeObject(zzzxpo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
