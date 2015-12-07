package ManagerStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import documentdata.CondemnDocu;
import po.CondemnDocuPO;
import po.StrategyPO;
import strategydata.StrategyData;

public class ManagerInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "FormulateStrategy":
				FormulateStrategy(ois, oos);
				break;
			case "GetUnapproveBill":
				GetUnapproveBill(ois, oos);
				break;
			case "CheckBill":
				CheckBill(ois, oos);
				break;
			case "ShowStrategy":
				ShowStrategy(ois, oos);
				break;
			case "ApproveBill":
				ApproveBill(ois, oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 批量审批单据
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void ApproveBill(ObjectInputStream ois, ObjectOutputStream oos) {
		CondemnDocu cd = new CondemnDocu();
		try {
			cd.update();
			oos.writeBoolean(true);
			oos.writeObject(new String("Ok"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 经营策略查看
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void ShowStrategy(ObjectInputStream ois, ObjectOutputStream oos) {
		StrategyData sd = new StrategyData();
		try {
			ArrayList<StrategyPO> spolist = sd.observe();
			oos.writeObject(spolist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查看表单
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void CheckBill(ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub
	}

	/**
	 * 审批单据
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void GetUnapproveBill(ObjectInputStream ois, ObjectOutputStream oos) {
		CondemnDocu cd = new CondemnDocu();
		try {
			ArrayList<CondemnDocuPO> cdpolist = cd.findall();
			oos.writeObject(cdpolist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 经营策略修改
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void FormulateStrategy(ObjectInputStream ois, ObjectOutputStream oos) {
		StrategyData sd = new StrategyData();
		try {
			StrategyPO spo = (StrategyPO) ois.readObject();
			sd.updatesalary(spo.getPosition(), spo.getSalary());
			sd.updateconstant(spo.getConstant());
			oos.writeBoolean(true);
			oos.writeObject(spo);
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
