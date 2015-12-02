package po;

import java.io.Serializable;
import java.util.ArrayList;

public class InputStorageList implements Serializable {
	private static final long serialVersionUID = 1L;
	ArrayList<InputStorageDocuPO> Slist=new ArrayList<InputStorageDocuPO>();
	
	public void addInputStoragePO(InputStorageDocuPO sli){
		Slist.add(sli);
	}

	public ArrayList<InputStorageDocuPO> getSlist() {
		return Slist;
	}
}
