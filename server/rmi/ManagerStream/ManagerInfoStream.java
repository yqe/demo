package ManagerStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StrategyPO;
import strategydata.StrategyData;

public class ManagerInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "FormulateStrategy":
				FormulateStrategy(ois, oos);
				break;
			case "ApproveBill":
				ApproveBill(ois, oos);
				break;
			case "CheckBill":
				CheckBill(ois, oos);
				break;
			case "AddAccount":
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void CheckBill(ObjectInputStream ois, ObjectOutputStream oos) {

	}

	private void ApproveBill(ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub

	}

	private void FormulateStrategy(ObjectInputStream ois, ObjectOutputStream oos) {
		StrategyData sd = new StrategyData();
		try {
			oos.writeObject(sd.observe());
			ArrayList<StrategyPO> spolist = (ArrayList<StrategyPO>) ois.readObject();
			for (int i = 0; i < spolist.size(); i++) {
				sd.updatesalary(spolist.get(i).getPosition(), spolist.get(i).getSalary());
			}
			sd.updateconstant(spolist.get(0).getConstant());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
