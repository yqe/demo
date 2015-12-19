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
	

	public boolean updatesalary(StrategyPO po) throws RemoteException;
	
	public boolean updateconstant(double cons) throws RemoteException;
	
	
}