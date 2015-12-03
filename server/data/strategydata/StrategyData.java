package strategydata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.StrategyPO;
import strategydataService.StrategyDataService;

public class StrategyData implements StrategyDataService{
		private String position;
		private int salary;
		private int constant;
		private ArrayList<StrategyPO> straList;
		MySqlImp mysqlimp;
	public ArrayList<StrategyPO> observe() throws RemoteException {
		// TODO Auto-generated method stub
		//返回了一个strategy的Arraylist，其中每个PO包含了职位，职位对应的月薪，价格计算常量
		try {
			int i=0;
			straList=new ArrayList<StrategyPO>();
			mysqlimp=new MySqlImp();
			String observe="SELECT *"+" FROM 经营策略";
			ResultSet rs=mysqlimp.query(observe);
			while(rs.next()){
			i++;
			straList.add(new StrategyPO(rs.getString(1),rs.getInt(2),rs.getInt(3)));
			System.out.println("薪水"+rs.getString(1)+"薪水"+rs.getInt(2)+rs.getInt(3));
			}
			return straList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in StrategyData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in StrategyData!");
			return null;
		}
		
		
	}


	public void updatesalary(String pos, int sal) throws RemoteException{
		// TODO Auto-generated method stub
		//更新职位相对应的月薪
		try {
			mysqlimp=new MySqlImp();
			String updatesal="UPDATE 经营策略"+" SET 月薪='"+sal+"' WHERE 职位='"+pos+"'";
			mysqlimp.update(updatesal);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in StrategyData!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in StrategyData!");
		}
		
	}


	public void updateconstant(int cons) throws RemoteException{
		// TODO Auto-generated method stub
		//更新价格计算常量，所有行都被设置为相同值
		try {
			mysqlimp=new MySqlImp();
			String updatecons="UPDATE 经营策略"+" SET 快递费价格计算常量="+cons;
			mysqlimp.update(updatecons);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in StrategyData!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in StrategyData!");
		}
	}

}
