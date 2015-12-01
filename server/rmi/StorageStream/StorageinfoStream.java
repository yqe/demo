package StorageStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.InputStorageList;
import po.OutStorageList;
import storagedata.StorageData;

public class StorageInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			if (ois.readUTF().equals("InStoragePO"))
				InStorageInfoGet(ois,oos);
			if(ois.readUTF().equals("OutStoragePO"))
				OutStorageInfoGet(ois,oos);
			if(ois.readUTF().equals("CheckStorage"))
				StorageCheckInfoGet(ois,oos);
			if(ois.readUTF().equals("SeeStorage"))
				StorageSeeInfoGet(ois,oos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void InStorageInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			InputStorageList slt = (InputStorageList) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void OutStorageInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			OutStorageList slt = (OutStorageList) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void StorageCheckInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		
	}
	public void StorageSeeInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		
	}
}
