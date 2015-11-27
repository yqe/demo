package stubanddriverserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InitializeAccountPO;
import po.DocumentPO;
import financedataService.FinanceDataService;

public class FinanceDataStub implements FinanceDataService {
	public void add(InitializeAccountPO po) throws RemoteException{
		System.out.println("增加账户成功");
		}
	public void delete(InitializeAccountPO po) throws RemoteException{
		System.out.println("删除账户成功");
		}
	public void update(InitializeAccountPO po) throws RemoteException{
		System.out.println("更新账户成功");
		}
	public void calculate(ArrayList<DocumentPO>  po) throws RemoteException{
		
	}
	public InitializeAccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	};

}
