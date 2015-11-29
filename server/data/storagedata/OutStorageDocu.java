package storagedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.OutStorageDocuPO;
import po.OutStorageList;
import po.StorageList;
import storagedataService.OutStorageService;

public class OutStorageDocu implements OutStorageService{
		MySqlImp mysqlimp;
		private String goodsID;
		private String outdate;
		private String destination;
		private String loadform;
		private	String transcentreID;
		ArrayList<OutStorageDocuPO> outsee;
		private String transcentrename;
		private String transcentercheck;
		
		//生成出库单,同时自动在库存盘点里删除一条记录
	public void StorageDataAdd(OutStorageList oslt) {
		OutStorageDocu  outdocu=new OutStorageDocu();
		outdocu.findtransname(oslt);
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
				String insert="INSERT INTO '"+transcentrename+"'"+" (快递编号,出库日期,目的地,装运形式,中转中心编号）"+" VALUES（'"+goodsID+"','"+outdate+"','"+destination+"','"+loadform+"','"+transcentreID+"')";
				//生成一条出库单
				String deletecheck="DELETE FROM '"+transcentercheck+"'"+" WHERE 快递编号='"+goodsID+"'";
				//删除一条库存记录
				mysqlimp.update(insert);
				mysqlimp.update(deletecheck);
				i--;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//查看所有的出库单
	public ArrayList<OutStorageDocuPO> StorageDataSee(String transID) {
		// TODO Auto-generated method stub
		OutStorageDocu  outdocu=new OutStorageDocu();
		outdocu.findnamebyid(transID);
		try {
			ArrayList<OutStorageDocuPO> outsee=new ArrayList<OutStorageDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM '"+transcentrename+"'";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				outsee.add(new OutStorageDocuPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outsee;
	}

	public void findtransname(OutStorageList oslt){
		ArrayList<OutStorageDocuPO> out=new ArrayList<OutStorageDocuPO>();
		OutStorageDocuPO outpo=out.get(0);
		
		switch(outpo.getTransferno()){
		case "025000":
			 transcentrename="南京出库单";
			 transcentercheck="南京库存盘点";
			 break;
		case "010000":
			 transcentrename="北京出库单";
			 transcentercheck="北京库存盘点";
			 break;
		case "020000":
			 transcentrename="广州出库单";
			 transcentercheck="广州库存盘点";
			 break;
		case "021000":
			 transcentrename="上海出库单";
			 transcentercheck="上海库存盘点";
			 break;
		}
		
		
	}
	
	public void findnamebyid(String ID){
		switch(ID){
		case "025000":
			 transcentrename="南京出库单";
			 transcentercheck="南京库存盘点";
			 break;
		case "010000":
			 transcentrename="北京出库单";
			 transcentercheck="北京库存盘点";
			 break;
		case "020000":
			 transcentrename="广州出库单";
			 transcentercheck="广州库存盘点";
			 break;
		case "021000":
			 transcentrename="上海出库单";
			 transcentercheck="上海库存盘点";
			 break;
		}
		
	}

	@Override
	public StorageList StorageDataCheck() {
		// TODO Auto-generated method stub
		
		return null;
	}
}
