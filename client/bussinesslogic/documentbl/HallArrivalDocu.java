package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.BussinessArrivalDocuPO;

public class HallArrivalDocu {
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;

	public HallArrivalDocu(ObjectOutputStream oos, ObjectInputStream ois) {
		this.ois=ois;
		this.oos=oos;
	}

	/**
	 * 建立营业厅到达单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildHallArrivalDocu(BussinessArrivalDocuPO bapo) {
		IsOk = false;
		try {
			oos.writeUTF("HallClerk");
			oos.writeUTF("ArrivalBill");
			oos.writeObject(new String("OK"));
			oos.writeObject(bapo);
//			IsOk = (boolean) ois.readObject();
			IsOk=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
