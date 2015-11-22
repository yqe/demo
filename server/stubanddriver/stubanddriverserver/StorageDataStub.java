package stubanddriverserver;

import po.OutStorageList;
import po.StorageList;
import po.StoragePO;
import storagedataService.StorageDataService;



/**
 * 
 * @author zxc
 * 
 * @Time 2015-10-25
 */
public class StorageDataStub implements StorageDataService {
	/**
	 * 库存信息增加
	 * 
	 * @param 增加的库存信息
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void StorageDataAdd(StoragePO svo) {
		System.out.println("StorageDataAdd()success");
	}

	/**
	 * 库存信息删除
	 * 
	 * @param 删除的库存信息
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void StorageDataDelete(StoragePO svo) {
		System.out.println("StorageDataDelete()success");
	}

	/**
	 * 库存信息查看
	 * 
	 * @param
	 * 
	 * @return 库存快照
	 * 
	 * @exception
	 */
//	public StoragePO[] StorageDataCheck() {
//		System.out.println("StorageDataCheck()success");
//		StoragePO[] sto = { new StoragePO("南京", "0000000001", "2015-10-11",
//				"上海", "航运区", 1, 1, 1) };
//		return sto;
//	}

	/**
	 * 查看库存
	 * 
	 * @param
	 * 
	 * @return 库存信息
	 * 
	 * @exception
	 */
	public String[] StorageDataSee() {
		System.out.println("StorageDataSee()success");
		String[] str = { "1000", "200", "500", "800" };

		return str;
	}

	public void StorageDataAdd(StorageList slt) {
		// TODO Auto-generated method stub
		
	}

	public void StorageDataDelete(OutStorageList oslt) {
		// TODO Auto-generated method stub
		
	}

	public StorageList StorageDataCheck() {
		// TODO Auto-generated method stub
		return null;
	}
}
