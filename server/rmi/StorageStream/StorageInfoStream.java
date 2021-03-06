package StorageStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.InputStorageList;
import po.LookStoragePO;
import po.OutStorageList;
import po.StorageAlarmPO;
import po.StorageCheckPO;
import po.StorageList;
import storagedata.InputStorageDocu;
import storagedata.LookStorage;
import storagedata.OutStorageDocu;
import storagedata.StorageAlarm;
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
			case "IDCheckStorage":
				IDCheckStorage(ois, oos);
				break;
			case "Storage110":
				Storage110(ois, oos);
				break;
			case "SetStorageAlarm":
				SetStorageAlarm(ois, oos);
				break;
			case "ChangeStorage":
				ChangeStorage(ois, oos);
				break;	
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 是否库存报警
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void SetStorageAlarm(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			String posID = (String) ois.readObject();
			StorageAlarmPO alarmpo = (StorageAlarmPO) ois.readObject();
			boolean isok = false;
			StorageAlarmPO alarmpo2 = new StorageAlarm().find(alarmpo.getTranscenterID());
			if (alarmpo2.getTranscenterID().equals("不存在"))
				isok = new StorageAlarm().insert(alarmpo);
			else
				isok = new StorageAlarm().update(alarmpo);
			oos.writeObject(new Boolean(isok));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 是否库存报警
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void Storage110(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			String posID = (String) ois.readObject();
			StorageAlarmPO alarmpo = new StorageAlarm().find(posID);
			int storednum = new LookStorage().getstorednum(posID);
			double temp = (storednum * 1.0) / alarmpo.getTotal();
			if (temp < alarmpo.getAlarmvalue())
				oos.writeObject(new Boolean(false));
			else
				oos.writeObject(new Boolean(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据快递编号查找快递库存信息
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void IDCheckStorage(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			String ID = (String) ois.readObject();
			StorageCheck stocheck = new StorageCheck();
			StorageCheckPO stopo = stocheck.find(ID);
			oos.writeObject(stopo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 库存信息更改
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void ChangeStorage(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			StorageCheckPO islt = (StorageCheckPO) ois.readObject();
			StorageCheck stocheck = new StorageCheck();
			boolean isok = stocheck.update(islt);
			oos.writeObject(new Boolean(isok));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			boolean isok = insto.InputStorageAdd(islt);
			oos.writeObject(new Boolean(isok));
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
			boolean isok = osto.StorageDataAdd(oslt);
			oos.writeObject(new Boolean(isok));
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
			String transID = (String) ois.readObject();
			ArrayList<StorageCheckPO> stolist = stocheck.findall(transID);
			StorageList slist=new StorageList();
			for (int i = 0; i < stolist.size(); i++) {
				slist.addStoragePO(stolist.get(i));
			}
			oos.writeObject(slist);
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
			String[] info = ((String) ois.readObject()).split(" ");
			int insto = looksto.inputStorageDataSeeNum(info[0], info[1], info[2]);
			int outsto = looksto.outStorageDataSeeNum(info[0], info[1], info[2]);
			int storednum = looksto.getstorednum(info[0]);
			double money = looksto.findmoney(info[0]);
			LookStoragePO stopo = new LookStoragePO(insto, outsto, storednum, money);
			oos.writeObject(stopo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
