package StorageStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.InputStorageList;
import po.OutStorageList;
import storagedata.InputStorageDocu;
import storagedata.LookStorage;
import storagedata.OutStorageDocu;

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
			
			oos.writeObject(new Boolean(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
		LookStorage looksto = new LookStorage();
	}
}
