package managedata;

import java.sql.ResultSet;
import java.sql.SQLException;

import managedataService.ManageAccountService;
import mysqlimp.MySqlImp;
import po.ManageAccountPO;

public class ManageAccount implements ManageAccountService {
	private String accountname;
	private double balance;
	private String accountID;
	private String password;
	MySqlImp mysqlimp;
	ManageAccountPO accpo;
	public ManageAccountPO find(String ID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String find="SELECT * FROM 账户管理"+" WHERE 账户ID='"+ID+"'";
			ResultSet rs=mysqlimp.query(find);
			accpo=new ManageAccountPO(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accpo;
	}

	public void insert(ManageAccountPO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			this.accountname=po.getAccountname();
			this.balance=po.getBalance();
			this.accountID=po.getAccountID();
			this.password=po.getPassword();
			String insert="INSERT INTO 账户管理"+" (账户名称,余额,账户ID,账户密码)"+" VALUES('"+accountname+"',"+balance+",'"+accountID+"','"+password+"')";
			mysqlimp.update(insert);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String ID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 账户管理"+" WHERE 账户ID='"+ID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(ManageAccountPO po) {
		// TODO Auto-generated method stub
		ManageAccount ma=new ManageAccount();
		ma.delete(po.getAccountID());
		ma.insert(po);
	}
		
}
