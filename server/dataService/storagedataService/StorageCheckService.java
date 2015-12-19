package storagedataService;

import java.util.ArrayList;

import po.StorageCheckPO;

public interface StorageCheckService {
	public boolean update(StorageCheckPO po);
	public boolean insert(StorageCheckPO po);
	public boolean delete(String ID);
	public  StorageCheckPO find(String ID);
	public int getnum(String transcenterID);
	public ArrayList<StorageCheckPO> findbydate(String date,String transID);
	
}
