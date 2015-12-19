package strategystubanddriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StrategyPO;

public class StrategyDataStub implements strategydataService.StrategyDataService{

	@Override
	public StrategyPO observe() throws RemoteException {
		// TODO Auto-generated method stub
		StrategyPO po=new StrategyPO(1,2,3,4,5,6,7,8);
		return po;
	}

	@Override
	public boolean updatesalary(StrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateconstant(double cons) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
