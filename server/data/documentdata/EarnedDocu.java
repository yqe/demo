package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.EarnedDocuService;
import goodsdata.ExpressTrail;
import managedata.CheckProfit;
import mysqlimp.MySqlImp;
import po.CondemnDocuPO;
import po.EarnedPO;
import po.ExpressTrailPO;

/**
 * @author jjlb 收款单
 */

public class EarnedDocu implements EarnedDocuService {
	private String paydate;// 付款日期
	private double earnedmoney;// 收款金额
	private String dilivername;// 收款快递员姓名
	private String orderID;// 订单条形码号
	private String bussinessID;// 所属营业厅编号
	private String bussinessname;// 营业厅名字
	MySqlImp mysqlimp;

	@Override
	public void insert(EarnedPO po) {
		// TODO Auto-generated method stub
		this.findnamebyID(po.getBussinessID());
		CondemnDocu condocu = new CondemnDocu();
		ExpressTrail expre = new ExpressTrail();
		try {
			mysqlimp = new MySqlImp();
			this.paydate = po.getPaydate();
			this.earnedmoney = po.getEarnedmoney();
			this.dilivername = po.getDilivername();
			this.orderID = po.getOrderID();
			this.bussinessID = po.getBussinessID();
			condocu.insert(new CondemnDocuPO("收款单", orderID, "未审批"));
			String insert = "INSERT INTO 收款单"
					+ " (收款日期,收款金额,收款快递员姓名,订单条形码号,所属营业厅编号)" + " VALUES('"
					+ paydate + "'," + earnedmoney + ",'" + dilivername + "','"
					+ orderID + "','" + bussinessID + "')";
			mysqlimp.update(insert);
			CheckProfit check = new CheckProfit();
			check.setearned(earnedmoney);// 总收入增加一条收入
			String track = "快件已到达" + bussinessname;
			expre.set(orderID, "营业厅轨迹", track);// 插入一条货运轨迹记录
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("Some MySql problem has happened in EarnedDocu!");
		}
	}

	@Override
	public void delete(String goodsID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp = new MySqlImp();
			String delete = "DELETE FROM 收款单" + " WHERE 订单条形码号='" + goodsID
					+ "'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("Some MySql problem has happened in EarnedDocu!");
		}
	}

	@Override
	public void update(EarnedPO po) {
		// TODO Auto-generated method stub
		EarnedDocu earn = new EarnedDocu();
		earn.delete(po.getOrderID());
		earn.insert(po);
	}

	// 根据一段时间查找收款单
	@Override
	public ArrayList<EarnedPO> findbytime(String timebegin, String timeend) {
		// TODO Auto-generated method stub

		try {
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			EarnedPO earnedpo;
			mysqlimp = new MySqlImp();
			String find = "SELECT 收款日期,收款金额,收款快递员姓名,订单条形码号,所属营业厅编号"
					+ " FROM 收款单" + " WHERE 收款日期>='" + timebegin
					+ "' and 收款日期<='" + timeend + "'";
			ResultSet rs = mysqlimp.query(find);
			while (rs.next()) {
				earnList.add(new EarnedPO(rs.getDate(1).toString(), rs
						.getDouble(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			return earnList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在", 2, "", "", ""));
			return earnList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out
					.println("Some MySql problem has happened in EarnedDocu!");
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在", 2, "", "", ""));
			return earnList;
		}

	}

	@Override
	public ArrayList<EarnedPO> findall() {
		// TODO Auto-generated method stub
		try {
			mysqlimp = new MySqlImp();
			ArrayList<EarnedPO> earnedList = new ArrayList<EarnedPO>();
			String findall = "SELECT *" + " FROM 收款单";
			ResultSet rs = mysqlimp.query(findall);
			while (rs.next()) {
				earnedList.add(new EarnedPO(rs.getDate(1).toString(), rs
						.getDouble(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			return earnedList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out
					.println("Some MySql problem has happened in EarnedDocu!");
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在", 2, "", "", ""));
			return earnList;
		}

	}

	@Override
	public ArrayList<EarnedPO> findbyID(String bussID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp = new MySqlImp();
			ArrayList<EarnedPO> earnedList = new ArrayList<EarnedPO>();
			String findbyID = "SELECT *" + " FROM 收款单" + " WHERE 所属营业厅编号='"
					+ bussID + "'";
			ResultSet rs = mysqlimp.query(findbyID);
			while (rs.next()) {
				earnedList.add(new EarnedPO(rs.getDate(1).toString(), rs
						.getDouble(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			return earnedList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在", 2, "", "", ""));
			return earnList;
		}

	}

	@Override
	public ArrayList<EarnedPO> findbydate(String date) {
		// TODO Auto-generated method stub

		try {
			System.out.println(date);
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			mysqlimp = new MySqlImp();
			String find = "SELECT 收款日期,收款金额,收款快递员姓名,订单条形码号,所属营业厅编号"
					+ " FROM 收款单" + " WHERE 收款日期='" + date + "'";
			ResultSet rs = mysqlimp.query(find);
			while (rs.next()) {
				earnList.add(new EarnedPO(rs.getDate(1).toString(), rs
						.getDouble(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			return earnList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in EarnedDocu!");
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在", 2, "", "", ""));
			return earnList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out
					.println("Some MySql problem has happened in EarnedDocu!");
			ArrayList<EarnedPO> earnList = new ArrayList<EarnedPO>();
			earnList.add(new EarnedPO("不存在", 2, "", "", ""));
			return earnList;
		}
	}

	// 根据营业厅编号找名字
	public void findnamebyID(String bussID) {
		switch (bussID) {
		case "025000":
			bussinessname = "南京营业厅";
			break;
		case "010000":
			bussinessname = "北京营业厅";
			break;
		case "020000":
			bussinessname = "广州营业厅";
			break;
		case "021000":
			bussinessname = "上海营业厅";
			break;
		}
	}

}
