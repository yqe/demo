package stubanddriverserver;

import transdataService.TransDataService;

import java.rmi.RemoteException;
public class TransDataDriver {
	public void drive(TransDataService transsdataStub) throws RemoteException{
		String info="12345";
		transsdataStub.find(info);
    }
}
