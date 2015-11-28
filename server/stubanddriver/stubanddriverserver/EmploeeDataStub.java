package stubanddriverserver;



import java.rmi.RemoteException;
import java.util.ArrayList;

import po.EmploeePO;

public class EmploeeDataStub implements employeedataService.EmploeeDataService{

	//public EmploeePO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		//System.out.println("find 213421");
		//return new EmploeePO("1231442");
	//}

	public void insertEmp(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("insert 张三  160011");
	}

	public void delete(String ID, EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("delete employee john 213221");
	}




	public EmploeePO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEmp(EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<EmploeePO> findall() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
