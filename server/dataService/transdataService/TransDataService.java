/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package transdataService;
import java.rmi.RemoteException;
import po.TransPO;
public interface TransDataService{
	public TransPO find(String info)throws RemoteException;//按所输入info查找返回相应的TransPO
	
}