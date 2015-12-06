package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.DiliverDocuService;
import mysqlimp.MySqlImp;
import po.CondemnDocuPO;
import po.DiliverDocuPO;

/**
 * @author jjlb
 *派件单
 */
public class DiliverDocu implements DiliverDocuService{
	private String orderID;//订单条形码号
	private String arrivaltime;//到达时间/
	private String receivername;//收件人姓名
	private String courier;//派送员
	MySqlImp mysqlimp;
	@Override
	public DiliverDocuPO find(String ID) {
		// TODO Auto-generated method stub
		try {
			DiliverDocuPO dipo;
			mysqlimp=new MySqlImp();
			String find="SELECT * FROM 派件单"+" WHERE 订单条形码号='"+ID+"'";
			ResultSet rs=mysqlimp.query(find);
			rs.next();
			dipo=new DiliverDocuPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			return dipo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in DilivverDocu!");
			return new DiliverDocuPO("不存在","","","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in getdistance!");
			return new DiliverDocuPO("不存在","","","");
		}
		
	}

	@Override
	public ArrayList<DiliverDocuPO> findall() {
		// TODO Auto-generated method stub
		try {
			ArrayList<DiliverDocuPO> dipoList=new ArrayList<DiliverDocuPO>();
			mysqlimp=new MySqlImp();
			String find="SELECT * FROM 派件单";
			ResultSet rs=mysqlimp.query(find);
			while(rs.next()){
			dipoList.add(new DiliverDocuPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			return dipoList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in DilivverDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in getdistance!");
			return null;
		}
	}

	@Override
	public void insert(DiliverDocuPO po) {
		// TODO Auto-generated method stub
		CondemnDocu condocu=new CondemnDocu();
		try {
			this.orderID=po.getOrderID();
			this.arrivaltime=po.getArrivaltime();
			this.receivername=po.getReceivername();
			this.courier=po.getCourier();
			mysqlimp=new MySqlImp();
			condocu.insert(new CondemnDocuPO("派件单", orderID, "未审批"));
			String insert="INSERT INTO 派件单"+" (订单条形码号,到达日期,收件人姓名,派送员)"+" VALUES('"+orderID+"','"+arrivaltime+"','"+receivername+"','"+courier+"')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in DilivverDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in getdistance!");
		}
	}

	@Override
	public void update(DiliverDocuPO po) {
		// TODO Auto-generated method stub
		DiliverDocu dido=new DiliverDocu();
		dido.delete(po.getOrderID());
		dido.insert(po);
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		try {
			
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 派件单"+" WHERE 订单条形码号='"+ID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in DilivverDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in getdistance!");
		}
	}

}
