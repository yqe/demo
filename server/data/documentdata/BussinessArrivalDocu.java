package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.BussinessArrivalDocuService;
import mysqlimp.MySqlImp;
import po.BussinessArrivalDocuPO;
import po.InputStorageDocuPO;

/**
 * @author jjlb
 *营业厅到达单
 */
public class BussinessArrivalDocu implements BussinessArrivalDocuService {
	private String arrivaltime;// 到达日期
	private String transferID;// 中转编号
	private String destination;// 目的地
	private String state;// 到达状态
	private String bussinessID;
	MySqlImp mysqlimp;
	private String bussinessname;

	@Override
	public void insert(BussinessArrivalDocuPO po) {
		// TODO Auto-generated method stub
		this.findnamebyID(po.getBussinessID());
		try {
			mysqlimp = new MySqlImp();
			this.arrivaltime = po.getArrivaltime();
			this.transferID = po.getTransferID();
			this.destination = po.getDestination();
			this.state = po.getState();
			this.bussinessID = po.getBussinessID();
			String insert = "INSERT INTO " + bussinessname + "" + " (到达日期,中转单编号,出发地,货物到达状态,营业厅编号)" + " VALUES('"
					+ arrivaltime + "','" + transferID + "','" + destination + "','" + state + "','" + bussinessID
					+ "')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in BussinessArrivalDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in BussinessArrivalDocu!");
		}
	}

	@Override
	public void delete(String transferID, String bussinessID) {
		// TODO Auto-generated method stub
		this.findnamebyID(bussinessID);
		try {
			mysqlimp = new MySqlImp();
			String delete = "DELETE FROM " + bussinessname + "" + " WHERE 中转单编号='" + transferID + "'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in BussinessArrivalDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in BussinessArrivalDocu!");
		}
	}

	@Override
	public void update(BussinessArrivalDocuPO po) {
		// TODO Auto-generated method stub
		this.delete(po.getTransferID(), po.getBussinessID());
		this.insert(po);
	}

	@Override
	public BussinessArrivalDocuPO find(String transferID, String bussinessID) {
		// TODO Auto-generated method stub
		this.findnamebyID(bussinessID);
		try {
			mysqlimp = new MySqlImp();
			String find = "SELECT * FROM " + bussinessname + "" + " WHERE 中转单编号='" + transferID + "'";
			ResultSet rs = mysqlimp.query(find);
			rs.next();
			BussinessArrivalDocuPO busspo = new BussinessArrivalDocuPO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5));
			return busspo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in BussinessArrivalDocu!");
			return new BussinessArrivalDocuPO("不存在", "不存在", "", "", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in BussinessArrivalDocu!");
			return new BussinessArrivalDocuPO("不存在", "不存在", "", "", "");
		}

	}

	@Override
	public ArrayList<BussinessArrivalDocuPO> findmore(String bussinessID) {
		// TODO Auto-generated method stub
		this.findnamebyID(bussinessID);
		try {
			ArrayList<BussinessArrivalDocuPO> busspoList = new ArrayList<BussinessArrivalDocuPO>();
			mysqlimp = new MySqlImp();
			String findall = "SELECT *" + " FROM " + bussinessname + "";
			ResultSet rs = mysqlimp.query(findall);
			while (rs.next()) {
				busspoList.add(new BussinessArrivalDocuPO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5)));
			}
			return busspoList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in BussinessArrivalDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in BussinessArrivalDocu!");
			return null;
		}
	}

	// 营业厅到达单
	public void findnamebyID(String transcenterID) {
		switch (transcenterID) {
		case "025000":
			bussinessname = "南京营业厅到达单";
			break;
		case "010000":
			bussinessname = "北京营业厅到达单";
			break;
		case "020000":
			bussinessname = "广州营业厅到达单";
			break;
		case "021000":
			bussinessname = "上海营业厅到达单";
			break;
		}

	}

}
