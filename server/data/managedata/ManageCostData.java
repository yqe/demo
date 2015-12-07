package managedata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import managedataService.ManageCostService;
import mysqlimp.MySqlImp;
import po.CostManagePO;

/**
 * @author jjlb
 *成本管理
 */
public class ManageCostData implements ManageCostService{
			MySqlImp mysqlimp;
		    private String date;//付款日期
		    private double payment;//付款金额
		    private  String payer;//付款人
		    private  String payaccount;//付款账号
		    private String tiaomu;//条目
		    private String tip;//备注
	public ArrayList<CostManagePO> find() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<CostManagePO> costList=new ArrayList<CostManagePO>();
		try {
			mysqlimp=new MySqlImp();
			String findall="SELECT * FROM 成本管理";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				costList.add(new CostManagePO(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
				//System.out.println(rs.getString(1)+rs.getDouble(2)+rs.getString(3)+rs.getString(4)+rs.getDouble(5)+rs.getDouble(6)+rs.getDouble(7)+rs.getDouble(8));
				//System.out.println(date+" "+payment+" "+payer+" "+payaccount+" "+rent+" "+transfee+" "+rentyear+" "+yundan+" "+" ");
			}
			return costList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in ManageCostData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageCostData!");
			return null;
		}
		
		
	}

	public void delete(String date) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(CostManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void insert(CostManagePO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			this.date=po.getDate();
			this.payment=po.getPayment();
			this.payer=po.getPayer();
			this.payaccount=po.getPayaccount();
			this.tiaomu=po.getTiaomu();
			this.tip=po.getTip();
			String insert="INSERT INTO 成本管理"+" (付款日期,付款金额,付款人,付款账号,条目,备注)"+" VALUES('"+date+"',"+payment+",'"+payer+"','"+payaccount+"','"+tiaomu+"','"+tip+"')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in ManageCostData!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageCostData!");
		}
		
	}
	
	
	public CostManagePO find(String paydate) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String findall="SELECT * FROM 成本管理"+" WHERE 付款日期='"+paydate+"'";
			ResultSet rs=mysqlimp.query(findall);
			rs.next();
			CostManagePO cost=new CostManagePO(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			return cost;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in ManageCostData!");
			return new CostManagePO("不存在",20,"","","","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in ManageCostData!");
			return new CostManagePO("不存在",20,"","","","");
		}
		
		
	}

	
}
