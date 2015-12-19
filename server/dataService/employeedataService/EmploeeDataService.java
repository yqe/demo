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
	
	public boolean insertEmp(EmploeePO po ) throws RemoteException;
	
	
	public boolean delete(String ID ) throws RemoteException;
	
	public boolean update( EmploeePO po ) throws RemoteException;
	
	public ArrayList<EmploeePO> findall()throws RemoteException;
	
	public ArrayList<EmploeePO> findbypos(String postion);
	
	public EmploeePO findbyname(String name ) throws RemoteException;
}
