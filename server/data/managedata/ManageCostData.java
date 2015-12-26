package managedata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import managedataService.ManageCostService;
import mysqlimp.MySqlImp;
import po.CostManagePO;
import po.ManageAccountPO;

/**
 * @author jjlb 成本管理
 */
public class ManageCostData implements ManageCostService {
	MySqlImp mysqlimp;
	private String date;// 付款日期
	private double payment;// 付款金额
	private String payer;// 付款人
	private String payaccount;// 付款账号
	private String tiaomu;// 条目
	private String tip;// 备注

	public ArrayList<CostManagePO> find() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<CostManagePO> costList = new ArrayList<CostManagePO>();
		try {
			mysqlimp = new MySqlImp();
			String findall = "SELECT * FROM 成本管理";
			ResultSet rs = mysqlimp.query(findall);
			while (rs.next()) {
				costList.add(new CostManagePO(rs.getDate(1).toString(), rs.getDouble(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6)));
				// System.out.println(rs.getString(1)+rs.getDouble(2)+rs.getString(3)+rs.getString(4)+rs.getDouble(5)+rs.getDouble(6)+rs.getDouble(7)+rs.getDouble(8));
				// System.out.println(date+" "+payment+" "+payer+"
				// "+payaccount+" "+rent+" "+transfee+" "+rentyear+" "+yundan+"
				// "+" ");
			}
			rs.close();
			return costList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in ManageCostData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageCostData!");
			ArrayList<CostManagePO> errcostList = new ArrayList<CostManagePO>();
			errcostList.add(new CostManagePO("不存在", 20, "", "", "", ""));
			return errcostList;
		}

	}

	public boolean delete(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean update(CostManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean insert(CostManagePO po) {
		// TODO Auto-generated method stub
		ManageAccount maacc = new ManageAccount();
		try {
			mysqlimp = new MySqlImp();
			this.date = po.getDate();
			this.payment = po.getPayment();
			this.payer = po.getPayer();
			this.payaccount = po.getPayaccount();
			this.tiaomu = po.getTiaomu();
			this.tip = po.getTip();
			String insert = "INSERT INTO 成本管理" + " (付款日期,付款金额,付款人,付款账号,条目,备注)" + " VALUES('" + date + "'," + payment
					+ ",'" + payer + "','" + payaccount + "','" + tiaomu + "','" + tip + "')";
			mysqlimp.update(insert);
			CheckProfit check = new CheckProfit();// 利润支出
			check.setcost(payment);
			String accname = maacc.find(payaccount).getAccountname();
			double money = maacc.find(payaccount).getBalance();
			if (!accname.equals("不存在")) {
				money -= payment;
				maacc.update(new ManageAccountPO(accname, money));
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in ManageCostData!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageCostData!");
			return false;
		}

	}

	public ArrayList<CostManagePO> findbytime(String timebegin, String timeend) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ArrayList<CostManagePO> cosList = new ArrayList<CostManagePO>();
			mysqlimp = new MySqlImp();
			String findall = "SELECT * FROM 成本管理" + " WHERE 付款日期>='" + timebegin + "' and 付款日期<='" + timeend + "'";
			ResultSet rs = mysqlimp.query(findall);
			while (rs.next()) {
				cosList.add(new CostManagePO(rs.getDate(1).toString(), rs.getDouble(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			rs.close();
			return cosList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in ManageCostData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageCostData!");
			ArrayList<CostManagePO> cosList = new ArrayList<CostManagePO>();
			cosList.add(new CostManagePO("不存在", 20, "", "", "", ""));
			return cosList;
		}

	}

	@Override
	public ArrayList<CostManagePO> findbydate(String date) {
		// TODO Auto-generated method stub
		try {
			ArrayList<CostManagePO> cosList = new ArrayList<CostManagePO>();
			mysqlimp = new MySqlImp();
			String findall = "SELECT * FROM 成本管理" + " WHERE 付款日期='" + date + "'";
			ResultSet rs = mysqlimp.query(findall);
			while (rs.next()) {
				cosList.add(new CostManagePO(rs.getDate(1).toString(), rs.getDouble(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			rs.close();
			return cosList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in ManageCostData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageCostData!");
			ArrayList<CostManagePO> cosList = new ArrayList<CostManagePO>();
			cosList.add(new CostManagePO("不存在", 20, "", "", "", ""));
			return cosList;
		}
	}

}
