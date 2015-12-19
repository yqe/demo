package storagedataService;

import java.util.ArrayList;

import po.InputStorageDocuPO;
import po.InputStorageList;
import po.OutStorageDocuPO;
import po.StorageList;


public interface InputStorageService {
	public boolean InputStorageAdd(InputStorageList inslt);


	public boolean InputStorageDelete(String goodsID);
	
	public StorageList StorageDataCheck();


	public ArrayList<InputStorageDocuPO> StorageDataSee(String transcenterID);
	
	public int storagenum(String transcenterID,String timebegin,String timeend);
}