/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package transblService;

import java.rmi.RemoteException;

public interface TransBlService {
	public String TransMaintenance(String info);// 更改车辆维护状态

	public String Transgetfee(String type, String depatureplace, String destination);// 计算并显示交通运费

}