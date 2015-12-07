package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.EarnedDocuService;
import mysqlimp.MySqlImp;
import po.CondemnDocuPO;
import po.EarnedPO;

/**
 * @author jjlb
 *收款单
 */
public class EarnedDocu implements EarnedDocuService{
	private String paydate;//付款日期
	private double earnedmoney;//收款金额
	private String dilivername;//收款快递员姓名
	private String orderID;//订单条形码号
	private String bussinessID;//所属营业厅编号
	MySqlImp mysqlimp;
	@Override
	public void insert(EarnedPO po) {
		// TODO Auto-generated method stub
		CondemnDocu condocu=new CondemnDocu();
		try {
			mysqlimp=new MySqlImp();
			this.paydate=po.getPaydate();
			this.earnedmoney=po.getEarnedmoney();
			this.dilivername=po.getDilivername();
			this.orderID=po.getOrderID();
			this.bussinessID=po.getBussinessID();
			condocu.insert(new CondemnDocuPO("收款单", orderID, "未审批"));
			String insert="INSERT INTO 收款单"+" (收款日期,收款金额,收款快递员姓名,订单条形码号,所属营业厅编号)"
			+" VALUES('"+paydate+"',"+earnedmoney+",'"+dilivername+"','"+orderID+"','"+bussinessID+"')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in EarnedDocu!");
		}
	}

	@Override
	public void delete(String goodsID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 收款单"+" WHERE 订单条形码号='"+goodsID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in EarnedDocu!");
		}
	}

	@Override
	public void update(EarnedPO po) {
		// TODO Auto-generated method stub
		 EarnedDocu earn=new  EarnedDocu();
		 earn.delete(po.getOrderID());
		 earn.insert(po);
	}

	@Override
	public ArrayList<EarnedPO> findbydate(String timebegin,String timeend) {
		// TODO Auto-generated method stub
	
		try {
			ArrayList<EarnedPO> earnList=new ArrayList<EarnedPO>();
			EarnedPO earnedpo;
			mysqlimp=new MySqlImp();
			String find="SELECT 收款日期,收款金额,收款快递员姓名,订单条形码号,所属营业厅编号"+" FROM 收款单"+" WHERE 收款日期>='"+timebegin+"' AND 收款日期<='"+timeend+"'";
			ResultSet rs=mysqlimp.query(find);
			while(rs.next()){
			earnList.add(new EarnedPO(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			return earnList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
			ArrayList<EarnedPO> earnList=new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在",2,"","",""));
			return earnList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in EarnedDocu!");
			ArrayList<EarnedPO> earnList=new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在",2,"","",""));
			return earnList;
		}
		
		
	}

	@Override
	public ArrayList<EarnedPO> findall() {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			ArrayList<EarnedPO> earnedList=new ArrayList<EarnedPO>();
			String findall="SELECT *"+" FROM 收款单";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				earnedList.add(new EarnedPO(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			return earnedList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in EarnedDocu!");
			return null;
		}
		
		
	}

	@Override
	public ArrayList<EarnedPO> findbyID(String bussID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
