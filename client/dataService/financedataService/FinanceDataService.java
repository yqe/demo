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

import po.AccountPO;
import po.DocumentPO;
public interface FinanceDataService {
	public AccountPO find (long  id) throws RemoteException;
	public void add(AccountPO po)throws RemoteException;
	public void delete(AccountPO po)throws RemoteException;
	public void update(AccountPO po)throws RemoteException;
	public void calculate(ArrayList<DocumentPO>  po)throws RemoteException;
}
