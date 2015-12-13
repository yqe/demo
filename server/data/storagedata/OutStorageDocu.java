package storagedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdata.CondemnDocu;
import mysqlimp.MySqlImp;
import po.CondemnDocuPO;
import po.OutStorageDocuPO;
import po.OutStorageList;
import po.StorageList;
import storagedataService.OutStorageService;

/**
 * @author jjlb
 *出库单
 */
public class OutStorageDocu implements OutStorageService{
		MySqlImp mysqlimp;
		private String goodsID;
		private String outdate;
		private String destination;
		private String loadform;
		private	String transcentreID;
		ArrayList<OutStorageDocuPO> outsee;
		private String transcentercheck;
		
		//生成出库单,同时自动在库存盘点里删除一条记录
	public void StorageDataAdd(OutStorageList oslt) {
	
		CondemnDocu condocu=new CondemnDocu();
		try {
			int i=0;
			ArrayList<OutStorageDocuPO> out=oslt.getSlist();
			mysqlimp=new MySqlImp();
			i=out.size();
			while(i>0){
				OutStorageDocuPO outpo=out.get(i);
				this.goodsID=outpo.getGoodno();
				this.outdate=outpo.getOuttime();
				this.destination=outpo.getDestination();
				this.loadform=outpo.getLoadform();
				this.transcentreID=outpo.getTransferno();
				condocu.insert(new CondemnDocuPO("出库单",goodsID, "未审批"));
				String insert="INSERT INTO 出库单"+" (快递编号,出库日期,目的地,装运形式,中转中心编号）"+" VALUES（'"+goodsID+"','"+outdate+"','"+destination+"','"+loadform+"','"+transcentreID+"')";
				//生成一条出库单
				String deletecheck="DELETE FROM 库存盘点"+" WHERE 快递编号='"+goodsID+"'";
				//删除一条库存记录
				mysqlimp.update(insert);
				mysqlimp.update(deletecheck);
				i--;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in OutStorageDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in OutStorageDocu!");
		}
		
	}

	public void StorageDataDelete(String goodsID) {
		// TODO Auto-generated method stub
		
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 出库单"+" WHERE 本次装箱托运单号='"+goodsID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in OutStorageDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in OutStorageDocu!");
		}
	}

	//查看所有的出库单
	public ArrayList<OutStorageDocuPO> StorageDataSee(String transID) {
		// TODO Auto-generated method stub
		try {
			ArrayList<OutStorageDocuPO> outsee=new ArrayList<OutStorageDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM 出库单"+" WHERE 中转中心编号='"+transID+"'";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				outsee.add(new OutStorageDocuPO(rs.getString(1),rs.getDate(2).toString(),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			rs.close();
			return outsee;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in OutStorageDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in OutStorageDocu!");
			ArrayList<OutStorageDocuPO> outsee=new ArrayList<OutStorageDocuPO>();
			outsee.add(new OutStorageDocuPO("不存在", "", "", "", ""));
			return outsee;
		}
		
	}
//
	//得到一段时间内的出库数量
	@Override
	public int OutStorageNum(String transcenterID, String timebegin,String timeend) {
		// TODO Auto-generated method stub
		try {
			int num=0;
			mysqlimp=new MySqlImp();
			String findbytime="SELECT 快递编号,出库日期,目的地,装运形式,中转中心编号"+" FROM 出库单"+" WHERE 出库日期>='"+timebegin+"' and 出库日期 <='"+timeend+"' and 中转中心编号='"+transcenterID+"'";
			ResultSet rs=mysqlimp.query(findbytime);
			while(rs.next()){
			num++;
			}
			rs.close();
			return num;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in OutStorageDocu!");
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in OutStorageDocu!");
			return 0;
		}
	}

	

}
