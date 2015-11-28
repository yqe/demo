package stubanddriverserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CostManagePO;
import po.EmploeePO;

import managedataService.ManageDataService;

public class ManageDataStub implements ManageDataService {

	public EmploeePO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("注销账户成功");
		
	}

	public void update(EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("更新信息完毕");
	}

	@Override
	public ArrayList<CostManagePO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String yundanID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CostManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(CostManagePO po) {
		// TODO Auto-generated method stub
		
	}

}
