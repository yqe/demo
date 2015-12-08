/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package financeblService;

import po.InitializeAccountPO;
import po.ManageAccountPO;

public interface FinanceBlService {
	
	/**
	 * 得到总收入,总支出,总利润;
	 * 
	 * @param
	 * @return String[] costinfo; costinfo[0]总收入,costinfo[1]总支出,costinfo[2]总利润.
	 * @exception @author
	 *                zxc
	 */
	public String[] GetCostInfo();
	// 期初建账
	public boolean InitAccount(InitializeAccountPO initacc);

	/**
	 * 建立增加账户
	 * 
	 * @param ManageAccountPO accpo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildBankAccount(ManageAccountPO accpo);
	/**
	 * 删除该id表示的银行账户
	 * 
	 * @param String id;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean DeleteBankAccount(String id);
	/**
	 * 修改银行账户信息
	 * 
	 * @param ManageAccountPO accpo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean ModifyBankAccount(ManageAccountPO accpo);
	/**
	 * 修改银行账户信息
	 * 
	 * @param ManageAccountPO accpo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean CheckBankAccount(String id);
}
