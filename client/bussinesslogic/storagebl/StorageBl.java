package storagebl;

import java.io.ObjectOutputStream;
import java.net.Socket;

import po.InputStorageList;
import po.OutStorageList;
import po.StorageList;
import storageblService.StorageBlService;

public class StorageBl implements StorageBlService{
	
	public void InStorageInput(InputStorageList slt) {
		System.out.println(slt.getSlist().get(0).getDestination());
		System.out.println("StorageBl.InStorageInputSuccess");
		try {
			Socket insto=new Socket("localhost",8888);
			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("InStoragePO");
			oos.writeObject(slt);
			oos.flush();
			oos.close();
			insto.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void OutStorageInput(OutStorageList oslt) {
		System.out.print(oslt.getSlist().get(0).getDestination());
		System.out.println("StorageBl.OutStorageInputSuccess");
		try {
			Socket insto=new Socket("localhost",8888);
			ObjectOutputStream oos=new ObjectOutputStream(insto.getOutputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("OutStoragePO");
			oos.writeObject(oslt);
			oos.flush();
			oos.close();
			insto.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InputStorageList StorageCheck() {
//		InputStorageDocuPO a = new InputStorageDocuPO("nanjing","210046","2015.10.11","beijing","01",23,12,23);
      
		InputStorageList n=new InputStorageList();
//        n.addInputStoragePO(a);;
		System.out.println("StorageBl.StorageCheckSuccess");
		return n;	
	}

	public String[] StorageSee() {
		String[] str={"100","100","100"};
		return str;
	}

	public void StorageUpdate(InputStorageList svo) {
		// TODO Auto-generated method stub
		
	}

}
