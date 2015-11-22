/**
 * 
 */
/**
 * @author acer-pc
 *
 */

package managedataService;



import java.rmi.RemoteException;

import po.EmploeePO;
public interface ManageDataService {
	public EmploeePO find (long  id) throws RemoteException;
	public void delete(EmploeePO po)throws RemoteException;
	public void update(EmploeePO po)throws RemoteException;
}

