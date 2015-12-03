package HallClerkStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import documentdata.ZzzxArrivalDocu;
import po.TransPO;
import po.VehicleMaintanceInfoPO;
import po.ZzzxArrivalDocuPO;
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

	private void ArrivalBill(ObjectInputStream ois, ObjectOutputStream oos) {
		ZzzxArrivalDocu zad = new ZzzxArrivalDocu();
		try {
			ZzzxArrivalDocuPO zapo = (ZzzxArrivalDocuPO) ois.readObject();
			zad.insert(zapo);
			oos.writeBoolean(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	private void ReceiveBill(ObjectInputStream ois, ObjectOutputStream oos) {

	}

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
