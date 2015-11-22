/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package distancedataService;
import java.rmi.RemoteException;
public interface DistanceDataService{
public double caldistance(String depatureplace,String destination)throws RemoteException;//按depatureplace和destination得出距离
}