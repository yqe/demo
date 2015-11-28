package stubanddriverserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransPO;
import transdataService.TransDataService;

public class transdataStub implements TransDataService{

	public TransPO find(String info) throws RemoteException {
		// TODO Auto-generated method stub
		TransPO transpo=new TransPO("2015-09-26","1124","78","8989","8989","898","909",90.0,"8989");
		System.out.println("TransPO find Success");
		return transpo;
	}

	@Override
	public void delete(String goodsID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(TransPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TransPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TransPO> findmore() {
		// TODO Auto-generated method stub
		return null;
	}

}
