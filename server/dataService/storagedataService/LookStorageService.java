package storagedataService;

import java.util.ArrayList;

import po.GoodsDocuPO;
import po.InputStorageDocuPO;
import po.OutStorageDocuPO;

public interface LookStorageService {
	public int inputStorageDataSeeNum(String transcenterID,String timebegin,String timeend);  
	
	public int  outStorageDataSeeNum(String transID,String timebegin,String timeend);
	
	public double findmoney(String ID );
	
	public int getstorednum(String ID);
}
