package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.BussinessArrivalDocuService;
import mysqlimp.MySqlImp;
import po.BussinessArrivalDocuPO;
import po.CondemnDocuPO;
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
	private String bussinessID;//营业厅编号
	MySqlImp mysqlimp;
	private String bussinessname;//营业厅名字

	@Override
	public void insert(BussinessArrivalDocuPO po) {
		// TODO Auto-generated method stub
		CondemnDocu condocu=new CondemnDocu();
		try {
			mysqlimp = new MySqlImp();
			this.arrivaltime = po.getArrivaltime();
			this.transferID = po.getTransferID();
			this.destination = po.getDestination();
			this.state = po.getState();
			this.bussinessID = po.getBussinessID();
			condocu.insert(new CondemnDocuPO("营业厅到达单", transferID, "未审批"));
			String insert = "INSERT INTO 营业厅到达单" + " (到达日期,中转单编号,出发地,货物到达状态,营业厅编号)" + " VALUES('"
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
		try {
			mysqlimp = new MySqlImp();
			String delete = "DELETE FROM 营业厅到达单" + " WHERE 中转单编号='" + transferID + "' and WHERE 营业厅编号='"+bussinessID+"'";
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
		try {
			mysqlimp = new MySqlImp();
			String find = "SELECT * FROM 营业厅到达单" + " WHERE 中转单编号='" + transferID + "' and WHERE 营业厅编号='"+bussinessID+"'";
			ResultSet rs = mysqlimp.query(find);
			rs.next();
			BussinessArrivalDocuPO busspo = new BussinessArrivalDocuPO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5));
			rs.close();
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
		try {
			ArrayList<BussinessArrivalDocuPO> busspoList = new ArrayList<BussinessArrivalDocuPO>();
			mysqlimp = new MySqlImp();
			String findall = "SELECT *" + " FROM 营业厅到达单"+" WHERE 营业厅编号='"+bussinessID+"'";
			ResultSet rs = mysqlimp.query(findall);
			while (rs.next()) {
				busspoList.add(new BussinessArrivalDocuPO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5)));
			}
			rs.close();
			return busspoList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in BussinessArrivalDocu!");
			ArrayList<BussinessArrivalDocuPO> busspoList = new ArrayList<BussinessArrivalDocuPO>();
			busspoList.add(new BussinessArrivalDocuPO("不存在", "","",
					"", ""));
			return busspoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in BussinessArrivalDocu!");
			ArrayList<BussinessArrivalDocuPO> busspoList = new ArrayList<BussinessArrivalDocuPO>();
			busspoList.add(new BussinessArrivalDocuPO("不存在", "","",
					"", ""));
			return busspoList;
		}
	}
	
	
	

}
