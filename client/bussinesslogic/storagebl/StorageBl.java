package storagebl;

import java.io.ObjectOutputStream;
import java.net.Socket;

import po.OutStorageList;
import po.StorageList;
import po.StoragePO;
import storageblService.StorageBlService;


public class StorageBl implements StorageBlService{
	
	public void InStorageInput(StorageList slt) {
		System.out.println(slt.getSlist().get(0).getDestination());
		System.out.println("StorageBl.InStorageInputSuccess");
//		try {
//			Socket insto=new Socket("localhost",8889);
//			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
//			oos.writeUTF("Storage");
//			oos.writeUTF("InStorageInput");
//			oos.writeObject(slt);
//			oos.flush();
//			oos.close();
//			insto.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

//
	public void InStorageDetele(int rank) {
		System.out.println("Storagebl.InStorageDeteleSuccess");
	}


	public void OutStorageInput(OutStorageList oslt) {
		System.out.print(oslt.getSlist().get(0).getDestination());
		System.out.println("StorageBl.OutStorageInputSuccess");
//		try {
//			Socket insto=new Socket("localhost",8889);
//			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
//			oos.writeUTF("OutStorageInput");
//			oos.writeObject(oslt);
//			oos.flush();
//			oos.close();
//			insto.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}


	public void OutStorageDelete(int rank) {
		System.out.println("StorageBl.OutStorageDeleteSuccess");
	}


	public StorageList StorageCheck() {
		StoragePO a = new StoragePO("nanjing","210046","2015.10.11","beijing","01",23,12,23);
      
		StorageList n=new StorageList();
        n.addStorageLineItem(a);;
		
       
		System.out.println("StorageBl.StorageCheckSuccess");
		return n;
		
		
	}


	public String[] StorageSee() {
		String[] str={"100","100","100"};
		return str;
	}


	public void StorageUpdate(StoragePO svo) {
      System.out.println("StorageBl.StorageUpdateSuccess");
		//		try {
//			Socket insto=new Socket("localhost",8888);
//			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
//			oos.writeUTF("StorageUpdate");
//			oos.writeObject(svo);
//			oos.flush();
//			oos.close();
//			insto.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}



}
