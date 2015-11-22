package stubanddriverserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.DocumentPO;
import financedataService.FinanceDataService;

public class FinanceDataStub implements FinanceDataService {
	public void add(AccountPO po) throws RemoteException{
		System.out.println("增加账户成功");
		}
	public void delete(AccountPO po) throws RemoteException{
		System.out.println("删除账户成功");
		}
	public void update(AccountPO po) throws RemoteException{
		System.out.println("更新账户成功");
		}
	public void calculate(ArrayList<DocumentPO>  po) throws RemoteException{
		
	}
	public AccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	};

}
