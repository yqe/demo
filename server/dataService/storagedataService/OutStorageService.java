package storagedataService;

import java.util.ArrayList;

import po.OutStorageDocuPO;
import po.OutStorageList;
import po.StorageList;

public interface OutStorageService {
	public void StorageDataAdd(OutStorageList slt);


	public void StorageDataDelete(OutStorageList oslt);
	
	public StorageList StorageDataCheck();


	public ArrayList<OutStorageDocuPO> StorageDataSee();

}
