package financedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import financedataService.InitialAccountService;
import mysqlimp.MySqlImp;
import po.InitializeAccountPO;
import po.TransPO;

public class Initialaccount implements InitialAccountService{
	private String bankaccountid;//银行账户id
	private String jigou;
	private String affair;//人员
	private int car;//车辆数
	private int storage;//库存量
	private double money;//银行账户余额
	private ArrayList<InitializeAccountPO> acpoList;
	MySqlImp mysqlimp;
	private InitializeAccountPO accpo;
	public InitializeAccountPO find(String bankaccountid) {
		// TODO Auto-generated method stub
		
		try {
			this.bankaccountid=bankaccountid;
			mysqlimp=new MySqlImp();
			String find="SELECT 银行账户ID,机构名称,人员,车辆,库存,银行账户余额"+" FROM 期初建账信息"+" WHERE 银行账户ID='"+bankaccountid+"'";
			ResultSet rs=mysqlimp.query(find);
			accpo=new InitializeAccountPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6));
			return accpo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
			return null;
		}
		
	
		
	}

	public void insert(InitializeAccountPO po) {
		// TODO Auto-generated method stub
		try {
			this.bankaccountid=po.getId();
			this.jigou=po.getJigou();
			this.affair=po.getAffair();
			this.car=po.getCar();
			this.storage=po.getStorage();
			this.money=po.getMoney();
			mysqlimp=new MySqlImp();
			String insert="INSERT INTO 期初建账信息"+" (银行账户ID,机构名称,人员,车辆,库存,银行账户余额)"+" VALUES('"+bankaccountid+"','"+jigou+"','"+affair+"',"+car+","+storage+","+money+")";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
		}
	}

	public void delete(String bid) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 期初建账信息"+" WHERE 银行账户ID='"+bid+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
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
				accList.add(new InitializeAccountPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6)));
			}
			return accList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in Initialaccount!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in Initialaccount!");
			return null;
		}
		
		
	}
		
}