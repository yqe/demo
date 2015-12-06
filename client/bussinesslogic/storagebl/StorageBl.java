package storagebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.InputStorageList;
import po.OutStorageList;
import po.StorageList;
import storageblService.StorageBlService;

public class StorageBl implements StorageBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String hostid="localhost";
	/**
	 * 入库登记
	 * 
	 * @param InputStorageList slt;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean InStorageInput(InputStorageList slt) {
		System.out.println(slt.getSlist().get(0).getDestination());
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("InStoragePO");
			oos.writeObject(slt);
			IsOk = ois.readBoolean();
			ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("StorageBl.InStorageInputSuccess");
		return IsOk;
	}
	/**
	 * 出库登记
	 * 
	 * @param OutStorageList oslt;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean OutStorageInput(OutStorageList oslt) {
		System.out.print(oslt.getSlist().get(0).getDestination());
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("OutStoragePO");
			oos.writeObject(oslt);
			IsOk = ois.readBoolean();
			ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("StorageBl.OutStorageInputSuccess");
		return IsOk;
	}

	public InputStorageList StorageCheck() {
		// InputStorageDocuPO a = new
		// InputStorageDocuPO("nanjing","210046","2015.10.11","beijing","01",23,12,23);

		InputStorageList n = new InputStorageList();
		// n.addInputStoragePO(a);;
		System.out.println("StorageBl.StorageCheckSuccess");
		return n;
	}

	public String[] StorageSee() {
		String[] str = { "100", "100", "100" };
		return str;
	}

	public void StorageUpdate(InputStorageList svo) {
		// TODO Auto-generated method stub

	}

}
