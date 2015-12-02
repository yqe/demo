package storagedataService;

import java.util.ArrayList;

import po.GoodsDocuPO;
import po.InputStorageDocuPO;
import po.OutStorageDocuPO;

public interface LookStorageService {
	public int inputStorageDataSeeNum(String transcenterID,String time);  
	
	public int  outStorageDataSeeNum(String transID,String time);
	
	public double findmoney(String ID );
}
