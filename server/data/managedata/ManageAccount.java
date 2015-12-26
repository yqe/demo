package managedata;

import java.sql.ResultSet;
import java.sql.SQLException;

import managedataService.ManageAccountService;
import mysqlimp.MySqlImp;
import po.ManageAccountPO;

/**
 * @author jjlb 账户管理
 */
public class ManageAccount implements ManageAccountService {
	private String accountname;
	private double balance;
	MySqlImp mysqlimp;
	ManageAccountPO accpo;

	public ManageAccountPO find(String name) {
		// TODO Auto-generated method stub
		try {
			mysqlimp = new MySqlImp();
			String find = "SELECT * FROM 账户管理" + " WHERE 账户名称='"+name+"'";
			ResultSet rs = mysqlimp.query(find);
			rs.next();
			accpo = new ManageAccountPO(rs.getString(1), rs.getDouble(2));
			rs.close();
			return accpo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			System.out.println("Class has some problem in ManageAccount!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageAccount!");
			return new ManageAccountPO("不存在", 2);
		}

	}

	public boolean insert(ManageAccountPO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp = new MySqlImp();
			this.accountname = po.getAccountname();
			this.balance = po.getBalance();
			
			String insert = "INSERT INTO 账户管理" + " (账户名称,余额)" + " VALUES('" + accountname + "'," + balance
					+ ")";
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

	public boolean delete(String name) {
		// TODO Auto-generated method stub
		try {
			mysqlimp = new MySqlImp();
			String s=this.find(name).getAccountname();
			if (s.equals("不存在")) {
				return false;
			} else {
				String delete = "DELETE FROM 账户管理" + " WHERE 账户名称='" + name + "'";
				mysqlimp.update(delete);
				return true;
			}
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
		this.delete(po.getAccountname());
		this.insert(po);
		return true;
	}
	
	public ManageAccountPO findthefirst(){
		try {
			
			mysqlimp=new MySqlImp();
			String findfir="SELECT *"+" FROM 账户管理"+" limit 1";
			ResultSet rs=mysqlimp.query(findfir);
			rs.next();
			accpo=new ManageAccountPO(rs.getString(1), rs.getDouble(2));
			return accpo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			accpo=new ManageAccountPO("不存在",0);
			return accpo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			accpo=new ManageAccountPO("不存在",0);
			return accpo;
		}
	}
}
