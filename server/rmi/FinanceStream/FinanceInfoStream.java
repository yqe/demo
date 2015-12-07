package FinanceStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import documentdata.EarnedDocu;
import managedata.ManageCostData;
import po.CostManagePO;
import po.EarnedPO;

public class FinanceInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "PaymentBill":
				PaymentBill(ois, oos);
				break;
			case "GetEarnedDocu":
				GetEarnedDocu(ois, oos);
				break;
			case "GetCostManageDocu":
				GetCostManageDocu(ois, oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按得到所给之间的所有付款单
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void GetCostManageDocu(ObjectInputStream ois, ObjectOutputStream oos) {
		ManageCostData costdata = new ManageCostData();
		try {
			String[] data = ((String) ois.readObject()).split(" ");
			ArrayList<CostManagePO> costpolist = costdata.find();
			oos.writeObject(costpolist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 按得到所给之间的所有收款单
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void GetEarnedDocu(ObjectInputStream ois, ObjectOutputStream oos) {
		EarnedDocu ed = new EarnedDocu();
		try {
			String[] data = ((String) ois.readObject()).split(" ");
			ArrayList<EarnedPO> epolist = ed.findall();
			oos.writeObject(epolist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 生成付款单
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	public void PaymentBill(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			ManageCostData mcost = new ManageCostData();
			CostManagePO costpo = (CostManagePO) ois.readObject();
			mcost.insert(costpo);
			oos.writeObject(new String("true"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
