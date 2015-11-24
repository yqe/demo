package StorageStream;

import java.io.ObjectInputStream;

import po.StorageList;
import storagedata.StorageData;

public class StorageinfoStream {
	StorageData sd=new StorageData();
	public StorageList InStorageInfoGet(ObjectInputStream ois){
		try {
			StorageList slt=(StorageList)ois.readObject();
			sd.StorageDataAdd(slt);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
}
