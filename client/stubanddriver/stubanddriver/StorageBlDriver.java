package stubanddriver;

import po.StorageList;
import po.StoragePO;
import storageblService.StorageBlService;

/**
 * 
 * @author zxc
 * 
 * @Time 2015-10-25
 */
public class StorageBlDriver {

	public void Driver(StorageBlService sbs) {

		sbs.InStorageInput(null);
		sbs.InStorageDetele(0);
		sbs.OutStorageInput(null);
		sbs.OutStorageDelete(0);
		StorageList sinfo = new StorageList();
		StoragePO sto = new StoragePO("南京", "0000000001", "2015-10-11", "上海", "航运区", 1, 1, 1);
		sbs.StorageCheck(sinfo);
		sbs.StorageSee("wuwa");
		sbs.StorageUpdate(sto);
	}
}
