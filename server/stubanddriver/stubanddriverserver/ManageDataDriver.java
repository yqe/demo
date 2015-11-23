package stubanddriverserver;



import java.rmi.RemoteException;

import po.EmploeePO;
import managedataService.ManageDataService;

public class ManageDataDriver {
	public void drive(ManageDataService ManageDataStub)throws RemoteException
	{ //EmploeePO a =new EmploeePO("tt");
	 //EmploeePO b =new EmploeePO("");
	 long id =231214;
	 ManageDataStub.find(id);
	 //ManageDataStub.update(b); 
	// ManageDataStub.delete(a);
		
		
		
	}

}
