package po;

import java.util.ArrayList;

public class InputStorageList {
ArrayList<InputStorageDocuPO> Slist=new ArrayList<InputStorageDocuPO>();
	
	public void addOutStoragePO(InputStorageDocuPO sli){
		Slist.add(sli);
	}

	public ArrayList<InputStorageDocuPO> getSlist() {
		return Slist;
	}
}
