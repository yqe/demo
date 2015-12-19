package managestubanddriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CostManagePO;
import po.EmploeePO;

import managedataService.ManageCostService;

public class ManageDataStub implements ManageCostService {

	@Override
	public ArrayList<CostManagePO> find() throws RemoteException {
		// TODO Auto-generated method stub
		 ArrayList<CostManagePO> list=new  ArrayList<CostManagePO>();
		 list.add(new CostManagePO("0000", 2, "ff", "111", "222", "@22"));
		return list;
	}

	@Override
	public boolean delete(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean update(CostManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean insert(CostManagePO po) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<CostManagePO> findbytime(String timebegin, String timeend) throws RemoteException {
		// TODO Auto-generated method stub
		 ArrayList<CostManagePO> list=new  ArrayList<CostManagePO>();
		 list.add(new CostManagePO("0000", 2, "ff", "111", "222", "@22"));
		return list;
	}

	@Override
	public ArrayList<CostManagePO> findbydate(String date) {
		// TODO Auto-generated method stub
		 ArrayList<CostManagePO> list=new  ArrayList<CostManagePO>();
		 list.add(new CostManagePO("0000", 2, "ff", "111", "222", "@22"));
		return list;
	}

	
}
