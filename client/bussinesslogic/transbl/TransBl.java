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
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;

	public TransBl(ObjectOutputStream oos, ObjectInputStream ois) {
		this.ois=ois;
		this.oos=oos;
	}
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
			oos.writeUTF("HallClerk");
			oos.writeUTF("CarInfoGet");
			oos.writeObject(new String(vehicleID));
			vpo = (VehicleMaintanceInfoPO) ois.readObject();
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
				oos.writeUTF("HallClerk");
				oos.writeUTF("CarInfoChange");
				oos.writeObject(vpo);
				IsOk = (boolean) ois.readObject();
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