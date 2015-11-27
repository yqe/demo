package storagedataService;

import java.net.ServerSocket;

import po.OutStorageList;
import po.StorageList;


public interface StorageDataService {

	public void StorageDataAdd(StorageList slt);

	public void StorageDataDelete(OutStorageList oslt);
	
	public StorageList StorageDataCheck();
	
	public String[] StorageDataSee();

}
