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
		private String accountID;
		private String password;
		public ManageAccountPO(String accountname,double balance,String accountID,String password){
			this.accountname=accountname;
			this.balance=balance;
			this.accountID=accountID;
			this.password=password;
		}
		public String getAccountname() {
			return accountname;
		}
		public double getBalance() {
			return balance;
		}
		public String getAccountID() {
			return accountID;
		}
		public String getPassword() {
			return password;
		}
}
