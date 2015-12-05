/**
 * 
 */
/**
 * @author acer-pc
 *
 */

package financedataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InitializeAccountPO;
import po.DocumentPO;
public interface FinanceDataService {
	public InitializeAccountPO find (long  id) throws RemoteException;
	public void add(InitializeAccountPO po)throws RemoteException;
	public void delete(InitializeAccountPO po)throws RemoteException;
	public void update(InitializeAccountPO po)throws RemoteException;
	public void calculate(ArrayList<DocumentPO>  po)throws RemoteException;
}
