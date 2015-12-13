package financebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import po.CostManList;
import po.CostManagePO;

public class CostManage {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;

	public CostManage(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos=oos;
		this.ois=ois;
	}

	/**
	 * 得到所给日期之间的所有付款单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	@SuppressWarnings("unchecked")
	public CostManList GetCostManageDocu(String datal, String datar) {
		CostManList cpolist = null;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("GetCostManageDocu");
			oos.writeObject(new String(datal + " " + datar));
			cpolist = (CostManList) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpolist;
	}

	/**
	 * 建立成本管理
	 * 
	 * @param CostManagePO
	 *            cmpo
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildCostManage(CostManagePO cmpo) {
		IsOk = false;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("PaymentBill");
			oos.writeObject(cmpo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
