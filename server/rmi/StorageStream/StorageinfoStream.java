package StorageStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.InputStorageList;
import po.OutStorageList;

public class StorageInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "InStoragePO":
				InStorageInfoGet(ois,oos);
				break;
			case "OutStoragePO":
				OutStorageInfoGet(ois,oos);
				break;
			case "CheckStorage":
				StorageCheckInfoGet(ois,oos);
				break;
			case "SeeStorage":
				StorageSeeInfoGet(ois,oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void InStorageInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			InputStorageList islt = (InputStorageList) ois.readObject();
			System.out.println(islt.getSlist().get(0).getIntime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void OutStorageInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			OutStorageList oslt = (OutStorageList) ois.readObject();
			System.out.println(oslt.getSlist().get(0).getGoodno());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void StorageCheckInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		
	}
	public void StorageSeeInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		
	}
}
