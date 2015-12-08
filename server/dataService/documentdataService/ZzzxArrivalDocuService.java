package documentdataService;

import java.util.ArrayList;


import po.ZzzxArrivalDocuPO;

public interface ZzzxArrivalDocuService {
	public ArrayList<ZzzxArrivalDocuPO> findall(String transID);
	
	public void delete(String goodsID);
	
	public void insert(ZzzxArrivalDocuPO po);
	
	public void update(ZzzxArrivalDocuPO po);
	public ZzzxArrivalDocuPO find(String transferNumber,String transcenterid);
}
