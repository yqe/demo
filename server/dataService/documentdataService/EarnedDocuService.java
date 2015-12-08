package documentdataService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.EarnedPO;

public interface EarnedDocuService {
	public void insert(EarnedPO po);
	
	public void delete(String goodsID);
	
	public void update(EarnedPO po);
	
	public ArrayList<EarnedPO> findbytime(String timebegin,String timeend);
	
	public ArrayList<EarnedPO> findall() ;
	
	public ArrayList<EarnedPO> findbyID(String bussID);
	
	public ArrayList<EarnedPO> findbydate(String date);
}
