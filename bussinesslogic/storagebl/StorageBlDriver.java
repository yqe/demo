package storagebl;

import java.util.ArrayList;

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

		sbs.InStorageInput();
		sbs.InStorageDetele(0);
		sbs.OutStorageinput();
		sbs.OutStorageDelete(0);
		StoragePO[] sinfo = { new StoragePO("南京", "0000000001", "2015-10-11",
				"上海", "航运区", 1, 1, 1) };
		sbs.StorageCheck(sinfo);
		sbs.StorageSee("wuwa");
		sbs.StorageUpdate(sinfo[0]);
	}
}
