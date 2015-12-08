package managedata;

import java.sql.ResultSet;
import java.sql.SQLException;

import managedataService.CheckProfitService;
import mysqlimp.MySqlImp;

/**
 * @author jjlb
 *收入支出利润的
 */
public class CheckProfit implements CheckProfitService{
	MySqlImp mysqlimp;
	@Override
	public double getearnedtotal() {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String getsum="SELECT SUM(收入) FROM 利润表";
			ResultSet rs=mysqlimp.query(getsum);
			rs.next();
			double result=rs.getDouble(1);
			rs.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public double getcosttotal() {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String getsum="SELECT SUM(支出) FROM 利润表";
			ResultSet rs=mysqlimp.query(getsum);
			rs.next();
			double result=rs.getDouble(1);
			rs.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public double profittotal() {
		// TODO Auto-generated method stub
		double profit=this.getearnedtotal()-this.getcosttotal();
		return profit;
	}

	@Override
	public void setearned(double earned) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String insert="INSERT INTO 利润表"+" (收入)"+" VALUES("+earned+")";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setcost(double cost) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String insert="INSERT INTO 利润表"+" (支出)"+" VALUES("+cost+")";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setprofit() {
		// TODO Auto-generated method stub
		
	}

}
