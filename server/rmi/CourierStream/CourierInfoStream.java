package CourierStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import documentdata.GoodsDocu;
import po.GoodsDocuPO;

public class CourierInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			if (ois.readUTF().equals("SendBill"))
				SendBill(ois,oos);
			if (ois.readUTF().equals("DeliveryBill"))
				DeliveryBill(ois,oos);
			if (ois.readUTF().equals("QueryOrder"))
				QueryOrder(ois,oos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void QueryOrder(ObjectInputStream ois, ObjectOutputStream oos) {
		GoodsDocu gd = new GoodsDocu();
		try {
			GoodsDocuPO gdpo = (GoodsDocuPO) ois.readObject();
			gdpo=gd.find(gdpo.getGoodsID());
			if(gdpo==null){
			oos.writeBoolean(true);}
			else{
				oos.writeObject(gdpo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DeliveryBill(ObjectInputStream ois, ObjectOutputStream oos) {
		
		
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
