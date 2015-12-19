package transstubanddriver;

import transdataService.TransDataService;

import java.rmi.RemoteException;

import po.TransPO;
public class TransDataDriver {
	public void drive(TransDataService transsdataStub) throws RemoteException{
		String info="12345";
		transsdataStub.find(info);
		transsdataStub.delete("ww");
		transsdataStub.findmore();
		transsdataStub.insert(new TransPO("222","222","33","44","555","66","22",3,"444"));
		transsdataStub.update(new TransPO("222","222","33","44","555","66","22",3,"444"));
		
    }
}
