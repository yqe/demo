package po;

import java.io.Serializable;
import java.util.ArrayList;


public class StorageList implements Serializable{
	private static final long serialVersionUID = 1L;
	ArrayList<StoragePO> Slist=new ArrayList<StoragePO>();
	
	public void addStorageLineItem(StoragePO sli){
		Slist.add(sli);
	}

	public ArrayList<StoragePO> getSlist() {
		return Slist;
	}
	
}
