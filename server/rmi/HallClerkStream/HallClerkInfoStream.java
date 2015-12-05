package HallClerkStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import documentdata.BussinessArrivalDocu;
import documentdata.EarnedDocu;
import po.BussinessArrivalDocuPO;
import po.EarnedPO;
import po.TransPO;
import po.VehicleMaintanceInfoPO;
import transdata.TransData;
import transdata.VehicleMaintance;

public class HallClerkInfoStream {
	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "LoadingList":
				LoadingList(ois, oos);
				break;
			case "ReceiveBill":
				ReceiveBill(ois, oos);
				break;
			case "CarInfoMaintain":
				CarInfoMaintain(ois, oos);
				break;
			case "ArrivalBill":
				ArrivalBill(ois, oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成中转中心到达单
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos
	 * @return
	 * @exception @author
	 *                zxc
	 */
	private void ArrivalBill(ObjectInputStream ois, ObjectOutputStream oos) {
		BussinessArrivalDocu  bad= new BussinessArrivalDocu();
		try {
			BussinessArrivalDocuPO badpo = (BussinessArrivalDocuPO) ois.readObject();
//			bad.insert(badpo);
			oos.writeBoolean(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 车辆信息维护
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos
	 * @return
	 * @exception @author
	 *                zxc
	 */
	private void CarInfoMaintain(ObjectInputStream ois, ObjectOutputStream oos) {
		VehicleMaintance vm = new VehicleMaintance();
		try {
			VehicleMaintanceInfoPO vmpo = (VehicleMaintanceInfoPO) ois.readObject();
			vmpo = vm.find(vmpo.getVehicleID());
			if (vmpo == null)
				oos.writeBoolean(false);
			else {
				oos.writeObject(vmpo);
				vmpo = (VehicleMaintanceInfoPO) ois.readObject();
				vm.update(vmpo);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 生成收款单
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos
	 * @return
	 * @exception @author
	 *                zxc
	 */
	private void ReceiveBill(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			EarnedDocu earn = new EarnedDocu();
			EarnedPO up = (EarnedPO) ois.readObject();
			earn.insert(up);
			oos.writeBoolean(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 生成装车单
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos
	 * @return
	 * @exception @author
	 *                zxc
	 */
	private void LoadingList(ObjectInputStream ois, ObjectOutputStream oos) {
		TransData td = new TransData();
		try {
			TransPO up = (TransPO) ois.readObject();
			td.insert(up);
			oos.writeBoolean(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
