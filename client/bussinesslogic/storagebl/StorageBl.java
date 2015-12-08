package storagebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.InputStorageDocuPO;
import po.InputStorageList;
import po.LookStoragePO;
import po.OutStorageList;
import storageblService.StorageBlService;

public class StorageBl implements StorageBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String hostid = "localhost";

	/**
	 * 入库登记
	 * 
	 * @param InputStorageList
	 *            slt;
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
			IsOk = (boolean) ois.readObject();
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
	 * @param OutStorageList
	 *            oslt;
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
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("StorageBl.OutStorageInputSuccess");
		return IsOk;
	}

	/**
	 * 库存信息盘点;
	 * 
	 * @param String
	 *            centerid; centerid:中转中心编号;
	 * @return InputStorageList;
	 * @exception @author
	 *                zxc
	 */
	public InputStorageList StorageCheck(String centerid) {
		InputStorageList Stolist = new InputStorageList();
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("SeeStorage");
			oos.writeObject(new String(centerid));
			Stolist = (InputStorageList) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Stolist;
	}

	/**
	 * 库存信息查看
	 * 
	 * @param String
	 *            centerid,String rtime,String ltime;
	 *            centerid:中转中心编号;rtime:前时间;ltime:后时间;
	 * @return String[] re;re[0]:出库数量;re[1]:入库数量;re[2]:金额;re[3]:库存数量;
	 * @exception @author
	 *                zxc
	 */
	public LookStoragePO StorageSee(String centerid, String rtime, String ltime) {
		LookStoragePO re = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("SeeStorage");
			oos.writeObject(new String(centerid + " " + rtime + " " + ltime));
			re = (LookStoragePO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	/**
	 * 库存信息更新;
	 * 
	 * @param InputStorageDocuPO
	 *            svo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean StorageUpdate(InputStorageDocuPO svo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Storage");
			oos.writeUTF("ChangeStorage");
			oos.writeObject(svo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

}
