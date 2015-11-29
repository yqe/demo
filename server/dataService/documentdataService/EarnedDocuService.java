package documentdataService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.EarnedPO;

public interface EarnedDocuService {
	public void insert(EarnedPO po);
	
	public void delete(String goodsID);
	
	public void update(EarnedPO po);
	
	public EarnedPO find(String goodsID);
	
	public ArrayList<EarnedPO> findall() ;
}
