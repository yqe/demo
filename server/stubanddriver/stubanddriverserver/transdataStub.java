package stubanddriverserver;

import java.rmi.RemoteException;

import po.TransPO;
import transdataService.TransDataService;

public class transdataStub implements TransDataService{

	public TransPO find(String info) throws RemoteException {
		// TODO Auto-generated method stub
		TransPO transpo=new TransPO();
		System.out.println("TransPO find Success");
		return transpo;
	}

}
