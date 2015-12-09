package StorageStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.InputStorageList;
import po.LookStoragePO;
import po.OutStorageList;
import po.StorageCheckPO;
import storagedata.InputStorageDocu;
import storagedata.LookStorage;
import storagedata.OutStorageDocu;
import storagedata.StorageCheck;

public class StorageInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "InStoragePO":
				InStorageInfoGet(ois, oos);
				break;
			case "OutStoragePO":
				OutStorageInfoGet(ois, oos);
				break;
			case "CheckStorage":
				StorageCheckInfoGet(ois, oos);
				break;
			case "SeeStorage":
				StorageSeeInfoGet(ois, oos);
				break;
			default:
				ChangeStorage(ois, oos);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 库存信息更改
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void ChangeStorage(ObjectInputStream ois, ObjectOutputStream oos) {
		
		
	}

	/**
	 * 入库登记
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	public void InStorageInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			InputStorageList islt = (InputStorageList) ois.readObject();
			InputStorageDocu insto = new InputStorageDocu();
			insto.InputStorageAdd(islt);
			oos.writeObject(new Boolean(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 出库登记
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	public void OutStorageInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			OutStorageList oslt = (OutStorageList) ois.readObject();
			OutStorageDocu osto = new OutStorageDocu();
			osto.StorageDataAdd(oslt);
			oos.writeObject(new Boolean(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 库存信息盘点
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	public void StorageCheckInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			StorageCheck stocheck = new StorageCheck();
			String transID=(String)ois.readObject();
			ArrayList<StorageCheckPO> stolist=stocheck.findall(transID);
			oos.writeObject(stolist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 库存信息查看
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	public void StorageSeeInfoGet(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			LookStorage looksto = new LookStorage();
			String[] info=((String)ois.readObject()).split(" ");
			int insto=looksto.inputStorageDataSeeNum(info[0], info[1], info[2]);
			int outsto=looksto.outStorageDataSeeNum(info[0], info[1], info[2]);
			int storednum=looksto.getstorednum(info[0]);
			double money=looksto.findmoney(info[0]);
			LookStoragePO stopo=new LookStoragePO(insto, outsto, storednum, money);
			oos.writeObject(stopo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LookStorage looksto = new LookStorage();
	}
}
