package emploeestubanddriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.EmploeePO;

public class EmploeeDataStub implements employeedataService.EmploeeDataService{

	@Override
	public EmploeePO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		EmploeePO emp=new EmploeePO("总经理",ID,"121",30,"女",30,"111","222","33243","2123","212332");
		return emp;
	}

	@Override
	public boolean insertEmp(EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
		}

	@Override
	public boolean update(EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<EmploeePO> findall() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<EmploeePO> List=new ArrayList<EmploeePO>();
		List.add(new EmploeePO("总经理","11","121",30,"女",30,"111","222","33243","2123","212332"));
		return List;
	}

	@Override
	public ArrayList<EmploeePO> findbypos(String postion) {
		// TODO Auto-generated method stub
		ArrayList<EmploeePO> List=new ArrayList<EmploeePO>();
		List.add(new EmploeePO("总经理","11","121",30,"女",30,"111","222","33243","2123","212332"));
		return List;
	}

	@Override
	public EmploeePO findbyname(String name) throws RemoteException {
		// TODO Auto-generated method stub
		EmploeePO emp=new EmploeePO("总经理","11","121",30,"女",30,"111","222","33243","2123","212332");
		return emp;
	}


}
