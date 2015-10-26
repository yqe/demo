package storagedataService;

import po.StoragePO;



/**
 * 
 * @author zxc
 * 
 * @Time 2015-10-25
 */
public class StorageDataServiceStub extends StorageDataService {
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
	public StoragePO[] StorageDataCheck() {
		System.out.println("StorageDataCheck()success");
		StoragePO[] sto = { new StoragePO("南京", "0000000001", "2015-10-11",
				"上海", "航运区", 1, 1, 1) };
		return sto;
	}

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
}
