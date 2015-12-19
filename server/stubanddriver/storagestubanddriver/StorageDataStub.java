package storagestubanddriver;

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

	@Override
	public boolean update(StorageCheckPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean insert(StorageCheckPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StorageCheckPO find(String ID) {
		// TODO Auto-generated method stub
		StorageCheckPO po=new StorageCheckPO("222","222","222","22","2","2","11");
		return po;
	}

	@Override
	public int getnum(String transcenterID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<StorageCheckPO> findbydate(String date, String transID) {
		// TODO Auto-generated method stub
		ArrayList<StorageCheckPO> list=new ArrayList<StorageCheckPO>();
		list.add(new StorageCheckPO("222","222","222","22","2","2","11"));
		return list;
	}

}
