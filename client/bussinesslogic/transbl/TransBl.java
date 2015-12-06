/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package transbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.VehicleMaintanceInfoPO;
import transblService.TransBlService;

public class TransBl implements TransBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	/**
	 * 得到车辆维护信息
	 * 
	 * @param String
	 *            vehicleID
	 * @return VehicleMaintanceInfoPO
	 * @exception @author
	 *                zxc
	 */
	public VehicleMaintanceInfoPO GetVehicleInfoPO(String vehicleID) {
		VehicleMaintanceInfoPO vpo = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("HallClerk");
			oos.writeUTF("CarInfoGet");
			oos.writeObject(new String(vehicleID));
			vpo = (VehicleMaintanceInfoPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vpo;
	}
	/**
	 * 车辆信息改变
	 * 
	 * @param String
	 *            vehicleID
	 * @return VehicleMaintanceInfoPO
	 * @exception @author
	 *                zxc
	 */
	public boolean ChangeVehicleInfoPO(VehicleMaintanceInfoPO vpo) {
		 IsOk = false;
			try {
				socket = new Socket(hostid, 8888);
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				oos.writeUTF("HallClerk");
				oos.writeUTF("CarInfoChange");
				oos.writeObject(vpo);
				IsOk = ois.readBoolean();
				ois.readObject();
				ois.close();
				oos.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return IsOk;
	}

	public String TransMaintenance(String info) {
		return info;
	}

	public String Transgetfee(String type, String depatureplace, String destination) {
		return destination;
	}

}