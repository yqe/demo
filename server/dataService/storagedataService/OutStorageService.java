package storagedataService;

import java.util.ArrayList;

import po.OutStorageDocuPO;
import po.OutStorageList;
import po.StorageList;

public interface OutStorageService {
	public void StorageDataAdd(OutStorageList oslt);


	public void StorageDataDelete(String goodsID);
	
	public int OutStorageNum(String transcenterID,String time);


	public ArrayList<OutStorageDocuPO> StorageDataSee(String transID);

}