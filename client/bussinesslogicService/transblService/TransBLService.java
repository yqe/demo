/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package transblService;

import java.rmi.RemoteException;

import po.VehicleMaintanceInfoPO;

public interface TransBlService {
	public String TransMaintenance(String info);// 更改车辆维护状态

	public String Transgetfee(String type, String depatureplace, String destination);// 计算并显示交通运费
	
	/**
	 * 得到车辆维护信息
	 * 
	 * @param String
	 *            vehicleID
	 * @return VehicleMaintanceInfoPO
	 * @exception @author
	 *                zxc
	 */
	public VehicleMaintanceInfoPO GetVehicleInfoPO(String vehicleID);
	
	/**
	 * 车辆信息改变
	 * 
	 * @param String
	 *            vehicleID
	 * @return VehicleMaintanceInfoPO
	 * @exception @author
	 *                zxc
	 */
	public boolean ChangeVehicleInfoPO(VehicleMaintanceInfoPO vpo);
}