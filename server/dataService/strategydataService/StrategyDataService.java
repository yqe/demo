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
	public StrategyPO observe() throws RemoteException;
	

	public void updatesalary(StrategyPO po) throws RemoteException;
	
	public void updateconstant(double cons) throws RemoteException;
	
	
}