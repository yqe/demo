/**
 * 
 */
/**
 * @author acer-pc
 *
 */

package managedataService;



import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CostManagePO;
import po.EmploeePO;
public interface ManageCostService {
	public ArrayList<CostManagePO> find()  throws RemoteException;
	public void delete(String date)throws RemoteException;
	public void update(CostManagePO po)throws RemoteException;
	public void insert(CostManagePO po);
}

