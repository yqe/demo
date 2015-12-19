package managestubanddriver;



import java.rmi.RemoteException;

import po.EmploeePO;
import managedataService.ManageCostService;

public class ManageDataDriver {
	public void drive(ManageCostService ManageDataStub)throws RemoteException
	{ //EmploeePO a =new EmploeePO("tt");
	 //EmploeePO b =new EmploeePO("");
		EmploeePO emp=new EmploeePO("总经理","111","121",30,"女",30,"111","222","33243","2123","212332");
	 long id =231214;
	 //ManageDataStub.find(id);
	 //ManageDataStub.update(b); 
	// ManageDataStub.delete(a);
		
		
		
	}

}
