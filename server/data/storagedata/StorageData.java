package storagedata;

import po.OutStorageList;
import po.StorageList;
import storagedataService.StorageDataService;

public class StorageData implements StorageDataService{

	public void StorageDataAdd(StorageList slt) {
		
		System.out.println(slt.getSlist().get(0).getArea()+slt.getSlist().get(1).getGoodno());
	}

	public void StorageDataDelete(OutStorageList oslt) {		
	}

	public StorageList StorageDataCheck() {

		return null;
	}

	public String[] StorageDataSee() {
		return null;
	}

}
