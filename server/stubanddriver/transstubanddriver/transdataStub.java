package transstubanddriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransPO;
import transdataService.TransDataService;

public class transdataStub implements TransDataService{

	@Override
	public TransPO find(String carsID) throws RemoteException {
		// TODO Auto-generated method stub
		TransPO po=new TransPO("222","222","33","44","555","66","22",3,"444");
		return po;
	}

	@Override
	public boolean delete(String goodsID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(TransPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TransPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<TransPO> findmore() {
		// TODO Auto-generated method stub
		ArrayList<TransPO> list=new ArrayList<TransPO>();
		list.add(new TransPO("222","222","33","44","555","66","22",3,"444"));
		return list;
	}

	

}
