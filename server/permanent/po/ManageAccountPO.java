package po;

import java.io.Serializable;

public class ManageAccountPO implements Serializable {
	private static final long serialVersionUID = 1L;
		private String accountname;
		private double balance;
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
