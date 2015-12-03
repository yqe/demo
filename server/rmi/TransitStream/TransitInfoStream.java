package TransitStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import documentdata.TransferDocu;
import documentdata.ZzzxArrivalDocu;
import po.TransferDocuPO;
import po.ZzzxArrivalDocuPO;

public class TransitInfoStream {
	
	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "TransitReceive":
				TransitReceive(ois,oos);
				break;
			case "ShipmentBill":
				ShipmentBill(ois,oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void TransitReceive(ObjectInputStream ois, ObjectOutputStream oos){
		try {
			ZzzxArrivalDocu zadu=new ZzzxArrivalDocu();
			ZzzxArrivalDocuPO zapo = (ZzzxArrivalDocuPO) ois.readObject();
			zadu.insert(zapo);
			oos.writeBoolean(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ShipmentBill(ObjectInputStream ois, ObjectOutputStream oos){
		try {
			TransferDocu td=new TransferDocu();
			TransferDocuPO tdpo = (TransferDocuPO) ois.readObject();
			td.insert(tdpo);
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
