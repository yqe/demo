package po;

import java.io.Serializable;
import java.util.ArrayList;

public class OutStorageList implements Serializable{
	private static final long serialVersionUID = 1L;
ArrayList<OutStoragePO> Slist=new ArrayList<OutStoragePO>();
	
	public void addOutStoragePO(OutStoragePO sli){
		Slist.add(sli);
	}

	public ArrayList<OutStoragePO> getSlist() {
		return Slist;
	}
}
