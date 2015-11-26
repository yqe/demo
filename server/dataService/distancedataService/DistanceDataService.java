/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package distancedataService;
import java.rmi.RemoteException;

import po.DistancePO;
public interface DistanceDataService{
public DistancePO getdistance(String departureplace,String destination)throws RemoteException;//按depatureplace和destination得出距离
}