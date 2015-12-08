package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.DiliverDocuPO;

public class Diliverdocu extends DocumentBl {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";
	/**
	 * 建立派件单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildDiliverDocu(DiliverDocuPO ddpo){
		IsOk = false;
		System.out.println(ddpo.getCourier());
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Courier");
			oos.writeUTF("DeliveryBill");
			oos.writeObject(ddpo);
			IsOk =(boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
		
	}
}
