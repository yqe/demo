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
	public void StorageDataAdd(OutStorageList oslt) {
				
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
				String insert="INSERT INTO 出库单"+" (快递编号,出库日期,目的地,装运形式,中转中心编号）"+" VALUES（'"+goodsID+"','"+outdate+"','"+destination+"','"+loadform+"','"+transcentreID+"')";
				mysqlimp.update(insert);
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

	public StorageList StorageDataCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OutStorageDocuPO> StorageDataSee() {
		// TODO Auto-generated method stub
		try {
			ArrayList<OutStorageDocuPO> outsee=new ArrayList<OutStorageDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM 出库单";
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

}
