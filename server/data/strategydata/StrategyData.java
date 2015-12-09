package strategydata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.StrategyPO;
import strategydataService.StrategyDataService;

public class StrategyData implements StrategyDataService{
	private int  topsal;//总经理月薪
	private int busssal;//营业厅业务员月薪
	private int storagemanagersal;//中转中心仓库管理员月薪
	private int storagesal;//中转中心业务员月薪
	private int financesal;//财务人员月薪
	private int diliversal;//快递员
	private int managersal;
	private double constance;//价格计算常量
		private ArrayList<StrategyPO> straList;
		MySqlImp mysqlimp;
	public StrategyPO observe() throws RemoteException {
		// TODO Auto-generated method stub
		//返回了一个strategy的Arraylist，其中每个PO包含了职位，职位对应的月薪，价格计算常量
		try {
			
			mysqlimp=new MySqlImp();
			String observe="SELECT *"+" FROM 经营策略";
			ResultSet rs=mysqlimp.query(observe);
			rs.next();
			StrategyPO strapo=new StrategyPO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8));
			System.out.println("薪水"+rs.getString(1)+"薪水"+rs.getInt(2)+rs.getInt(3));
			
			rs.close();
			return strapo;
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


	public void updatesalary(StrategyPO po) throws RemoteException{
		// TODO Auto-generated method stub
		//更新职位相对应的月薪
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 经营策略";
			mysqlimp.update(delete);
			this.topsal=po.getTopsal();
			this.busssal=po.getBusssal();
			this.storagemanagersal=po.getStoragemanagersal();
			this.storagesal=po.getStoragesal();
			this.financesal=po.getFinancesal();
			this.diliversal=po.getDiliversal();
			this.managersal=po.getManagersal();
			this.constance=po.getConstance();
			String insert="INSERT INTO 经营策略"+" (总经理,营业厅业务员,中转中心业务员,中转中心库存管理人员,快递员,财务人员,管理员,快递费价格计算常量)"+" VALUES("+topsal+","+busssal+","+
					storagemanagersal+","+storagesal+","+financesal+","+diliversal+","+managersal+","+constance+")";
			mysqlimp.update(insert);
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


	public void updateconstant(double cons) throws RemoteException{
		// TODO Auto-generated method stub
		//更新价格计算常量，所有行都被设置为相同值
		try {
			mysqlimp=new MySqlImp();
			String updatecons="UPDATE 经营策略"+" SET 快递费价格计算常量="+cons+"";
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
		
	public double getconstance(){
		try {
			mysqlimp=new MySqlImp();
			String getcons="SELECT 快递费价格计算常量"+" FROM 经营策略";
			ResultSet rs=mysqlimp.query(getcons);
			rs.next();
			double cons=rs.getDouble(1);
			rs.close();
			return cons;
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
}
