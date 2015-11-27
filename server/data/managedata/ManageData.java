package managedata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import managedataService.ManageDataService;
import mysqlimp.MySqlImp;
import po.CostManagePO;

public class ManageData implements ManageDataService{
			MySqlImp mysqlimp;
		 	private String date;//付款日期
		 	private double payment;//付款金额
		    private  String payer;//付款人
		    private  String payaccount;//付款账号
		    private  String rent;//租金
		    private double transfee;//运费
		    private String rentyear;//租金年份
		    private String yundan;//运单号
		    private double salarymonth;//人员工资
	public ArrayList<CostManagePO> find() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<CostManagePO> costList=new ArrayList<CostManagePO>();
		try {
			mysqlimp=new MySqlImp();
			String findall="SELECT * FROM 成本管理";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				costList.add(new CostManagePO(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getString(9),));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void delete(String yundanID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(CostManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void insert(CostManagePO po) {
		// TODO Auto-generated method stub
		
	}

}
