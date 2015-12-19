package storagestubanddriver;

import java.rmi.RemoteException;

import po.StorageCheckPO;
import storagedataService.StorageCheckService;

/**
 *
 * @author zxc
 * 
 * @Time 2015-10-25
 */
public class StorageDataDriver {
	public void drive(StorageCheckService StorageDataStub) throws RemoteException{
		StorageDataStub.delete("111");
		StorageDataStub.find("222");
		StorageDataStub.findbydate("ee", "222");
		StorageDataStub.getnum("222");
		StorageDataStub.insert(new StorageCheckPO("222","222","222","22","2","2","11"));
		StorageDataStub.update(new StorageCheckPO("222","222","222","22","2","2","11"));
	    }

}
