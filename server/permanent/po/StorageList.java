package po;

import java.io.Serializable;
import java.util.ArrayList;


public class StorageList implements Serializable{
	private static final long serialVersionUID = 1L;
	ArrayList<StorageCheckPO> Slist=new ArrayList<StorageCheckPO>();
	
	public void addStoragePO(StorageCheckPO sli){
		Slist.add(sli);
	}

	public ArrayList<StorageCheckPO> getSlist() {
		return Slist;
	}
	
}
