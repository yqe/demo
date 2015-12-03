package stubanddriverserver;

import java.util.ArrayList;

import po.OutStorageList;
import po.StorageCheckPO;
import po.StorageList;
import storagedataService.StorageCheckService;



/**
 * 
 * @author zxc
 * 
 * @Time 2015-10-25
 */
public class StorageDataStub implements StorageCheckService {
	/**
	 * 库存信息增加
	 * 
	 * @param 增加的库存信息
	 * 
	 * @return
	 * 
	 * @exception
	 */
	public void StorageDataAdd(StorageCheckPO svo) {
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
	public void StorageDataDelete(StorageCheckPO svo) {
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

	@Override
	public void update(StorageCheckPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(StorageCheckPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StorageCheckPO find(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StorageCheckPO> findbydate(String date) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public void StorageDataAdd(InputStorageDocuPO po) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public ArrayList<StorageCheckPO> StorageDataCheck() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
