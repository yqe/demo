package CourierStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import documentdata.DiliverDocu;
import documentdata.GoodsDocu;
import po.DiliverDocuPO;
import po.GoodsDocuPO;

public class CourierInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "SendBill":
				SendBill(ois, oos);
				break;
			case "DeliveryBill":
				DeliveryBill(ois, oos);
				break;
			case "QueryOrder":
				QueryOrder(ois, oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void QueryOrder(ObjectInputStream ois, ObjectOutputStream oos) {
		GoodsDocu gd = new GoodsDocu();
		try {
			GoodsDocuPO gdpo = (GoodsDocuPO) ois.readObject();
			gdpo = gd.find(gdpo.getGoodsID());
			if (gdpo == null) {
				oos.writeBoolean(true);
			} else {
				oos.writeObject(gdpo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DeliveryBill(ObjectInputStream ois, ObjectOutputStream oos) {
		DiliverDocu ddp=new DiliverDocu();
		try {
			DiliverDocuPO gdpo = (DiliverDocuPO) ois.readObject();
			ddp.insert(gdpo);
			oos.writeBoolean(true);
			oos.writeObject(gdpo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void SendBill(ObjectInputStream ois, ObjectOutputStream oos) {
		GoodsDocu gd = new GoodsDocu();
		try {
			GoodsDocuPO gdpo = (GoodsDocuPO) ois.readObject();
			gd.insert(gdpo);
			oos.writeBoolean(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
