package documentdataService;

import java.util.ArrayList;


import po.ZzzxArrivalDocuPO;

public interface ZzzxArrivalDocuService {
	public ArrayList<ZzzxArrivalDocuPO> findall(String transID);
	
	public boolean delete(String goodsID);
	
	public boolean insert(ZzzxArrivalDocuPO po);
	
	public boolean update(ZzzxArrivalDocuPO po);
	public ZzzxArrivalDocuPO find(String transferNumber,String transcenterid);
}
