package storagedataService;

import java.util.ArrayList;

import po.InputStorageDocuPO;
import po.InputStorageList;
import po.OutStorageDocuPO;
import po.StorageList;


public interface InputStorageService {
	public void InputStorageAdd(InputStorageList inslt);


	public void InputStorageDelete(String goodsID);
	
	public StorageList StorageDataCheck();


	public ArrayList<InputStorageDocuPO> StorageDataSee(String transcenterID);
}