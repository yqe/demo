package storageblService;

import java.util.ArrayList;
import po.StoragePO;

/**
 * 
 * @author zxc
 * 
 * @Time 2015-10-25
 */
public class StorageBlServiceStub extends StorageBlService {

	/**
	 * 库存信息输入
	 * 
	 * @param
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void InStorageInput() {
		System.out.println("InStorageInput()success");
	}

	/**
	 * 删除输入的库存信息
	 * 
	 * @param 输入的库存信息号数
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void InStorageDetele(int rank) {
		System.out.println("InStorageDetele()success");
	}

	/**
	 * 出库信息输入
	 * 
	 * @param
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void OutStorageinput() {
		System.out.println("OutStorageinput()success");
	}

	/**
	 * 删除输入的出库信息
	 * 
	 * @param 输入的出库信息号数
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void OutStorageDelete(int rank) {
		System.out.println("OutStorageDelete()success");
	}

	/**
	 * 显示库存快照
	 * 
	 * @param Storageinfo库存信息
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void StorageCheck(StoragePO[] svo) {
		System.out.println("StorageCheck()success");
	}

	/**
	 * 显示库存快照
	 * 
	 * @param 库存信息
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void StorageSee(String info) {
		System.out.println("StorageSee()success");
	}

	/**
	 * 更新库存信息
	 * 
	 * @param 更新的库存信息
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void StorageUpdate(StoragePO svo) {
		System.out.println("StorageUpdate()success");
	}

}
