package emploeestubanddriver;


import java.rmi.RemoteException;

import po.EmploeePO;

public class EmploeeDataDriver {
	public void drive(employeedataService.EmploeeDataService EmploeeDataStub) throws RemoteException{
		  EmploeeDataStub.find("231434");
		  EmploeeDataStub.insertEmp(new EmploeePO("总经理","11","121",30,"女",30,"111","222","33243","2123","212332"));
		  EmploeeDataStub.delete("23144");
		  EmploeeDataStub.update(new EmploeePO("总经理","11","121",30,"女",30,"111","222","33243","2123","212332"));
	  }
}
