package ManagerStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CondemnDocuPO;
import po.CondemnList;
import po.EmploeePO;
import po.StrategyPO;
import strategydata.EmploeeData;
import strategydata.StrategyData;
import documentdata.CondemnDocu;

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
			case "IDGetEmployeeInfo":
				IDGetEmployeeInfo(ois, oos);
				break;
			case "GetOEmployee":
				GetOEmployee(ois, oos);
				break;
			case "ModifyEmpInfo":
				ModifyEmpInfo(ois, oos);
				break;
			case "DeleteEmpInfo":
				DeleteEmpInfo(ois, oos);
				break;
			case "AddEmpInfo":
				AddEmpInfo(ois, oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增加员工信息
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void AddEmpInfo(ObjectInputStream ois, ObjectOutputStream oos) {
		EmploeeData emdata = new EmploeeData();
		try {
			EmploeePO empo = (EmploeePO) ois.readObject();
			boolean isok = emdata.insertEmp(empo);
			oos.writeObject(new Boolean(isok));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据员工Id删除员工信息
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void DeleteEmpInfo(ObjectInputStream ois, ObjectOutputStream oos) {
		EmploeeData emdata = new EmploeeData();
		try {
			String empoid = (String) ois.readObject();
			boolean isok = emdata.delete(empoid);
			oos.writeObject(new Boolean(isok));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据ID修改员工信息;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void ModifyEmpInfo(ObjectInputStream ois, ObjectOutputStream oos) {
		EmploeeData emdata = new EmploeeData();
		try {
			EmploeePO empo = (EmploeePO) ois.readObject();
			boolean isok = emdata.update(empo);
			oos.writeObject(new Boolean(isok));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据机构得到此机构所有员工信息
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void GetOEmployee(ObjectInputStream ois, ObjectOutputStream oos) {
		EmploeeData emdata = new EmploeeData();
		try {
			String org = (String) ois.readObject();
			ArrayList<EmploeePO> empolist = emdata.findall();
			oos.writeObject(empolist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据Id查找员工信息
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void IDGetEmployeeInfo(ObjectInputStream ois, ObjectOutputStream oos) {
		EmploeeData emdata = new EmploeeData();
		try {
			String Id = (String) ois.readObject();
			EmploeePO empo = emdata.find(Id);
			oos.writeObject(empo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 批量审批单据
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void ApproveBill(ObjectInputStream ois, ObjectOutputStream oos) {
		CondemnDocu cd = new CondemnDocu();
		try {
			boolean isok = cd.update();
			oos.writeObject(new Boolean(isok));
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
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void ShowStrategy(ObjectInputStream ois, ObjectOutputStream oos) {
		StrategyData sd = new StrategyData();
		try {
			String o=(String)ois.readObject();
			StrategyPO spolist = sd.observe();
			oos.writeObject(spolist);
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

	/**
	 * 查看表单
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void CheckBill(ObjectInputStream ois, ObjectOutputStream oos) {

	}

	/**
	 * 审批单据
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void GetUnapproveBill(ObjectInputStream ois, ObjectOutputStream oos) {
		CondemnDocu cd = new CondemnDocu();
		try {
			String ok = (String) ois.readObject();
			ArrayList<CondemnDocuPO> cdpolist = cd.findall();
			CondemnList cdlist = new CondemnList();
			for (int i = 0; i < cdpolist.size(); i++) {
				cdlist.AddCondemnDocuPO(cdpolist.get(i));
			}
			oos.writeObject(cdlist);
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

	/**
	 * 经营策略修改
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void FormulateStrategy(ObjectInputStream ois, ObjectOutputStream oos) {
		StrategyData sd = new StrategyData();
		try {
			ois.readObject();
			StrategyPO spo = (StrategyPO) ois.readObject();
			System.out.println(spo.getManagersal());
			boolean isok = sd.updatesalary(spo);
			oos.writeObject(new Boolean(isok));
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
