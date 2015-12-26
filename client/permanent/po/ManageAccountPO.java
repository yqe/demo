package po;

import java.io.Serializable;
/**
 * 账户管理
 * @author jjlb
 *
 */
public class ManageAccountPO implements Serializable {
	private static final long serialVersionUID = 1L;
		private String accountname;//账户名称
		private double balance;//账户余额
		public ManageAccountPO(String accountname,double balance){
			this.accountname=accountname;
			this.balance=balance;
		}
		public String getAccountname() {
			return accountname;
		}
		public double getBalance() {
			return balance;
		}
}
