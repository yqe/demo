package financedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import financedataService.InitialAccountService;
import managedata.ManageAccount;
import mysqlimp.MySqlImp;
import po.InitializeAccountPO;
import po.ManageAccountPO;

/**
 * @author jjlb
 *期初建账
 */
public class Initialaccount implements InitialAccountService{
	private String bankaccountname;//银行账户名称
	private String jigou;
	private int affair;//人员
	private int car;//车辆数
	private int storage;//库存量
	private double money;//银行账户余额
	private ArrayList<InitializeAccountPO> acpoList;
	MySqlImp mysqlimp;
	private InitializeAccountPO accpo;
	ManageAccount maacc;
	public InitializeAccountPO find(String bankaccountname) {
		// TODO Auto-generated method stub
		
		try {
			this.bankaccountname=bankaccountname;
			mysqlimp=new MySqlImp();
			String find="SELECT 银行账户名称,机构名称,人员,车辆,库存,银行账户余额"+" FROM 期初建账信息"+" WHERE 银行账户名称='"+bankaccountname+"'";
			ResultSet rs=mysqlimp.query(find);
			accpo=new InitializeAccountPO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6));
			rs.close();
			return accpo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
			return new InitializeAccountPO("不存在","",3,4,5,5);
		}
		
	
		
	}

	public boolean insert(InitializeAccountPO po) {
		// TODO Auto-generated method stub
		try {
			maacc=new ManageAccount();
			this.bankaccountname=po.getId();
			this.jigou=po.getJigou();
			this.affair=po.getAffair();
			this.car=po.getCar();
			this.storage=po.getStorage();
			this.money=po.getMoney();
			mysqlimp=new MySqlImp();
			String insert="INSERT INTO 期初建账信息"+" (银行账户名称,机构名称,人员,车辆,库存,银行账户余额)"+" VALUES('"+bankaccountname+"','"+jigou+"','"+affair+"',"+car+","+storage+","+money+")";
			mysqlimp.update(insert);
			ManageAccountPO mapo=new ManageAccountPO(bankaccountname,money);
			if(!maacc.find(bankaccountname).equals("不存在")){
				maacc.update(mapo);
				return true;
			}else{
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
			return false;
		}
	}

	public boolean delete(String bid) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 期初建账信息"+" WHERE 银行账户ID='"+bid+"'";
			mysqlimp.update(delete);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
			return false;
		}
	}

	public ArrayList<InitializeAccountPO> findmore() {
		// TODO Auto-generated method stub
		ArrayList<InitializeAccountPO> accList=new ArrayList<InitializeAccountPO>();
		try {
			mysqlimp=new MySqlImp();
			String findmore="SELECT * FROM 期初建账信息";
			ResultSet rs=mysqlimp.query(findmore);
			while(rs.next()){
				accList.add(new InitializeAccountPO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6)));
			}
			rs.close();
			return accList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
			ArrayList<InitializeAccountPO> erraccList=new ArrayList<InitializeAccountPO>();
			erraccList.add(new InitializeAccountPO("不存在","",3,4,5,5));
			return erraccList;
		}
		
		
	}
		
}
