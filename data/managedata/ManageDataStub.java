package managedata;

import java.rmi.RemoteException;

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

}
