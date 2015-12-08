package storagedataService;

import java.util.ArrayList;

import po.StorageCheckPO;

public interface StorageCheckService {
	public void update(StorageCheckPO po);
	public void insert(StorageCheckPO po);
	public void delete(String ID);
	public  StorageCheckPO find(String ID);
	public ArrayList<StorageCheckPO> findbydate(String date,String transID);
	
}
