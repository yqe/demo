package storagedataService;

import java.util.ArrayList;

import po.OutStorageDocuPO;
import po.OutStorageList;
import po.StorageList;

public interface OutStorageService {
	public boolean StorageDataAdd(OutStorageList oslt);


	public boolean StorageDataDelete(String goodsID);
	
	public int OutStorageNum(String transcenterID,String timebegin,String timeend);


	public ArrayList<OutStorageDocuPO> StorageDataSee(String transID);

}
