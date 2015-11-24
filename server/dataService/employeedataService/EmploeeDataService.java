/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package employeedataService;

import java.rmi.RemoteException;

import po.EmploeePO;


public interface EmploeeDataService{
	public EmploeePO find(String ID ) throws RemoteException;
	
	public void insertEmp(EmploeePO po ) throws RemoteException;
	
	
	public void delete(String ID ) throws RemoteException;
	
	public void update(String ID, EmploeePO po ) throws RemoteException;
	
	public void modify(String ID, EmploeePO po ) throws RemoteException;
	
	
}
