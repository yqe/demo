/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package strategydataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StrategyPO;

public interface StrategyDataService{
	public ArrayList<StrategyPO> observe() throws RemoteException;
	

	public void updatesalary(String pos,int sal) throws RemoteException;
	
	public void updateconstant(int cons) throws RemoteException;
}