package FinanceStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import documentdata.ZzzxArrivalDocu;
import po.ZzzxArrivalDocuPO;

public class FinanceInfoStream {
	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			if (ois.readUTF().equals("PaymentBill"))
				PaymentBill(ois, oos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaymentBill(ObjectInputStream ois, ObjectOutputStream oos){
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
}
