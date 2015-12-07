/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package employeedataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.EmploeePO;


public interface EmploeeDataService{
	public EmploeePO find(String ID ) throws RemoteException;
	
	public void insertEmp(EmploeePO po ) throws RemoteException;
	
	
	public void delete(String ID ) throws RemoteException;
	
	public void update( EmploeePO po ) throws RemoteException;
	
	public ArrayList<EmploeePO> findall()throws RemoteException;
	
	public ArrayList<EmploeePO> findbypos(String postion);
	
}
