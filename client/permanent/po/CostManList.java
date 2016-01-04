package po;

import java.io.Serializable;
import java.util.ArrayList;

public class CostManList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	ArrayList<CostManagePO> Costlist=new ArrayList<>();
	
	public void AddCostManage(CostManagePO costpo){
		Costlist.add(costpo);
	}
	
	public int GetSize(){
		return Costlist.size();
	}
	
	public CostManagePO GetIndex(int i){
		return Costlist.get(i);
	}
}
