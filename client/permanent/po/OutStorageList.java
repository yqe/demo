package po;

import java.io.Serializable;
import java.util.ArrayList;

public class OutStorageList implements Serializable{
	private static final long serialVersionUID = 1L;
ArrayList<OutStorageDocuPO> Slist=new ArrayList<OutStorageDocuPO>();
	
	public void addOutStoragePO(OutStorageDocuPO sli){
		Slist.add(sli);
	}

	public ArrayList<OutStorageDocuPO> getSlist() {
		return Slist;
	}
}
