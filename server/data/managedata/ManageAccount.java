package managedata;

import java.sql.ResultSet;
import java.sql.SQLException;

import managedataService.ManageAccountService;
import mysqlimp.MySqlImp;
import po.ManageAccountPO;

/**
 * @author jjlb
 *账户管理
 */
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
			rs.close();
			return accpo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in ManageAccount!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageAccount!");
			return new ManageAccountPO("不存在",2,"","");
		}
		
	}

	public boolean insert(ManageAccountPO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			this.accountname=po.getAccountname();
			this.balance=po.getBalance();
			this.accountID=po.getAccountID();
			this.password=po.getPassword();
			String insert="INSERT INTO 账户管理"+" (账户名称,余额,账户ID,账户密码)"+" VALUES('"+accountname+"',"+balance+",'"+accountID+"','"+password+"')";
			mysqlimp.update(insert);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in ManageAccount!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageAccount!");
			return false;
		}
	}

	public boolean delete(String ID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 账户管理"+" WHERE 账户ID='"+ID+"'";
			mysqlimp.update(delete);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in ManageAccount!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageAccount!");
			return false;
		}
	}

	public boolean update(ManageAccountPO po) {
		// TODO Auto-generated method stub
		ManageAccount ma=new ManageAccount();
		ma.delete(po.getAccountID());
		ma.insert(po);
		return true;
	}
		
}
