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
	private String name;//银行账户名称
	private double money;//银行账户余额
	private ArrayList<InitializeAccountPO> acpoList;
	MySqlImp mysqlimp;
	private InitializeAccountPO accpo;
	public InitializeAccountPO find(String bankaccountid) {
		// TODO Auto-generated method stub
		
		try {
			this.bankaccountid=bankaccountid;
			mysqlimp=new MySqlImp();
			String find="SELECT 银行账户ID,机构名称,人员,车辆,库存,银行账户名称,银行账户余额"+" FROM 期初建账信息"+" WHERE 银行账户ID='"+bankaccountid+"'";
			ResultSet rs=mysqlimp.query(find);
			accpo=new InitializeAccountPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDouble(7));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return accpo;
	}

	public void insert(InitializeAccountPO po) {
		// TODO Auto-generated method stub
		try {
			this.bankaccountid=po.getId();
			this.jigou=po.getJigou();
			this.affair=po.getAffair();
			this.car=po.getCar();
			this.storage=po.getStorage();
			this.name =po.getName();
			this.money=po.getMoney();
			mysqlimp=new MySqlImp();
			String insert="INSERT INTO 期初建账信息"+" (银行账户ID,机构名称,人员,车辆,库存,银行账户名称,银行账户余额)"+" VALUES('"+bankaccountid+"','"+jigou+"','"+affair+"',"+car+","+storage+",'"+name+"',"+money+")";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				accList.add(new InitializeAccountPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDouble(7)));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accList;
		
	}
		
}
