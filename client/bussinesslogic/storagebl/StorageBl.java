package storagebl;

import java.io.ObjectOutputStream;
import java.net.Socket;

import po.OutStorageList;
import po.StorageList;
import po.StoragePO;
import storageblService.StorageBlService;
import storagedataService.StorageDataService;


public class StorageBl implements StorageBlService{
	
	public void InStorageInput(StorageList slt) {
		try {
			Socket insto=new Socket("localhost",8889);
			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("InStorageInput");
			oos.writeObject(slt);
			oos.flush();
			oos.close();
			insto.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void InStorageDetele(int rank) {
		
	}


	public void OutStorageInput(OutStorageList oslt) {
		try {
			Socket insto=new Socket("localhost",8889);
			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
			oos.writeUTF("OutStorageInput");
			oos.writeObject(oslt);
			oos.flush();
			oos.close();
			insto.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void OutStorageDelete(int rank) {
	}


	public void StorageCheck(StorageList slt) {
		
	}


	public void StorageSee(String info) {
	}


	public void StorageUpdate(StoragePO svo) {
		try {
			Socket insto=new Socket("localhost",8888);
			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
			oos.writeUTF("StorageUpdate");
			oos.writeObject(svo);
			oos.flush();
			oos.close();
			insto.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
