package documentdataService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.EarnedPO;

public interface EarnedDocuService {
	public boolean insert(EarnedPO po);
	
	public boolean delete(String goodsID);
	
	public boolean update(EarnedPO po);
	
	public ArrayList<EarnedPO> findbytime(String timebegin,String timeend);
	
	public ArrayList<EarnedPO> findall() ;
	
	public ArrayList<EarnedPO> findbyID(String bussID);
	
	public ArrayList<EarnedPO> findbydate(String date);
}
