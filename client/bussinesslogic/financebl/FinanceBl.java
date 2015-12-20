/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package financebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.InitializeAccountPO;
import po.ManageAccountPO;
import financeblService.FinanceBlService;

public class FinanceBl implements FinanceBlService {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	
	public FinanceBl(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos=oos;
		this.ois=ois;
	}

	/**
	 * 期初建账;
	 * 
	 * @param InitializeAccountPO initacc
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean InitAccount(InitializeAccountPO initacc) {
		IsOk=false;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("InitAccount");
			oos.writeObject(initacc);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	/**
	 * 得到总收入,总支出,总利润;
	 * 
	 * @param
	 * @return String[] costinfo; costinfo[0]总收入,costinfo[1]总支出,costinfo[2]总利润.
	 * @exception @author
	 *                zxc
	 */
	public String[] GetCostInfo() {
		String[] costinfo = new String[3];
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("CostCheck");
			oos.writeObject(new String("0"+" "+"0"+" "));
			costinfo = ((String) ois.readObject()).split(" ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return costinfo;
	}

	/**
	 * 建立增加账户
	 * 
	 * @param ManageAccountPO
	 *            accpo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildBankAccount(ManageAccountPO accpo) {
		IsOk = false;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("BankAccount");
			oos.writeUTF("BuildBankAccount");
			oos.writeObject(accpo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	/**
	 * 删除该id表示的银行账户
	 * 
	 * @param String
	 *            id;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean DeleteBankAccount(String id) {
		IsOk = false;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("BankAccount");
			oos.writeUTF("DeleteBankAccount");
			oos.writeObject(new String(id));
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	/**
	 * 修改银行账户信息
	 * 
	 * @param ManageAccountPO
	 *            accpo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean ModifyBankAccount(ManageAccountPO accpo) {
		IsOk = false;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("BankAccount");
			oos.writeUTF("ChangeBankAccount");
			oos.writeObject(accpo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	/**
	 * 修改银行账户信息
	 * 
	 * @param ManageAccountPO
	 *            accpo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public ManageAccountPO CheckBankAccount(String id) {
		ManageAccountPO accpo = null;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("BankAccount");
			oos.writeUTF("CheckBankAccount");
			oos.writeObject(new String(id));
			accpo=(ManageAccountPO) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accpo;
	}
}
