package FinanceStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import documentdata.EarnedDocu;
import financedata.Initialaccount;
import managedata.CheckProfit;
import managedata.ManageAccount;
import managedata.ManageCostData;
import po.CostManagePO;
import po.EarnedPO;
import po.InitializeAccountPO;
import po.ManageAccountPO;

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
			case "BankAccount":
				JudgeCmd2(ois, oos);
				break;
			case "CostCheck":
				CostCheck(ois, oos);
				break;
			default:
				InitAccount(ois, oos);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void JudgeCmd2(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "BuildBankAccount":
				BuildBankAccount(ois, oos);
				break;
			case "ChangeBankAccount":
				ChangeBankAccount(ois, oos);
				break;
			case "CheckBankAccount":
				CheckBankAccount(ois, oos);
				break;
			case "DeleteBankAccount":
				DeleteBankAccount(ois, oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 期初建账;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void InitAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			Initialaccount init = new Initialaccount();
			InitializeAccountPO initpo = (InitializeAccountPO) ois.readObject();
			init.insert(initpo);
			oos.writeObject(new Boolean(true));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查看经营情况表;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void CostCheck(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			String coststr = "";
			CheckProfit cp = new CheckProfit();
			double profit = cp.getearnedtotal() - cp.getcosttotal();
			coststr = cp.getearnedtotal() + " " + cp.getcosttotal() + " " + profit;
			oos.writeObject(new String(coststr));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 建立银行账户;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void BuildBankAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			ManageAccount bankacc = new ManageAccount();
			ManageAccountPO accpo = (ManageAccountPO) ois.readObject();
			if (bankacc.find(accpo.getAccountID()).getAccountID().equals("不存在")) {
				bankacc.insert(accpo);
				oos.writeObject(new Boolean(true));
			} else
				oos.writeObject(new Boolean(false));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改银行账户;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void ChangeBankAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			ManageAccount bankacc = new ManageAccount();
			ManageAccountPO accpo = (ManageAccountPO) ois.readObject();
			bankacc.update(accpo);
			oos.writeObject(new Boolean(true));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查看银行账户;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void CheckBankAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			ManageAccount bankacc = new ManageAccount();
			String accpoid = (String) ois.readObject();
			ManageAccountPO accpo = bankacc.find(accpoid);
			oos.writeObject(accpo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除银行账户;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void DeleteBankAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			ManageAccount bankacc = new ManageAccount();
			String accpoid = (String) ois.readObject();
			if (bankacc.find(accpoid).getAccountID().equals("不存在"))
				oos.writeObject(new Boolean(false));
			else {
				bankacc.delete(accpoid);
				oos.writeObject(new Boolean(true));
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
	 * 按得到所给之间的所有付款单;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void GetCostManageDocu(ObjectInputStream ois, ObjectOutputStream oos) {
		ManageCostData costdata = new ManageCostData();
		try {
			ArrayList<CostManagePO> costpolist;
			String[] data = ((String) ois.readObject()).split(" ");
			// if(data[0].equals("ID"))
			// costpolist = costdata.find(data[2]);
			// else if(data[1].equals("day"))
			// costpolist = costdata.find(data[2]);
			// else
			costpolist = costdata.find();
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
	 * 按得到所给之间的所有收款单;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
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
	 * 生成付款单;
	 * 
	 * @param
	 * @return ObjectInputStream ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	public void PaymentBill(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			ManageCostData mcost = new ManageCostData();
			CostManagePO costpo = (CostManagePO) ois.readObject();
			mcost.insert(costpo);
			oos.writeObject(new Boolean(true));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
