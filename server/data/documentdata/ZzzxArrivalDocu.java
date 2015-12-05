package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.ZzzxArrivalDocuService;
import mysqlimp.MySqlImp;
import po.TransPO;
import po.ZzzxArrivalDocuPO;

public class ZzzxArrivalDocu implements ZzzxArrivalDocuService{
	private String transferCenterNum;//中转中心编号
	private String arrivalDate;
	private String transferNumber;//中转单编号
	private String startPlace;//出发地
	private String goodsState;//货物到达状态
	MySqlImp mysqlimp;
	public ArrayList<ZzzxArrivalDocuPO> findall() {
		// TODO Auto-generated method stub
		ArrayList<ZzzxArrivalDocuPO> zzzxpo=new ArrayList<ZzzxArrivalDocuPO>();
		try {
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM 中转中心到达单";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				this.transferCenterNum=rs.getString(1);
				this.arrivalDate=rs.getString(2);
				this.transferNumber=rs.getString(3);
				this.startPlace=rs.getString(4);
				this.goodsState=rs.getString(5);
				zzzxpo.add(new ZzzxArrivalDocuPO(transferCenterNum,arrivalDate,transferNumber,startPlace,goodsState));
			}
			return zzzxpo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in ZzzxArrivalDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in ZzzxArrivalDocu!");
			return null;
		}
		
	}

	public void delete(String goodsID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 中转中心到达单"+" WHERE 中转单编号='"+goodsID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in ZzzxArrivalDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in ZzzxArrivalDocu!");
		}
	}

	public void insert(ZzzxArrivalDocuPO po) {
		// TODO Auto-generated method stub
			try {
				mysqlimp=new MySqlImp();
				this.transferCenterNum=po.getTransferCenterNum();
				this.arrivalDate=po.getArrivalDate();
				this.transferNumber=po.getTransferNumber();
				this.startPlace=po.getStartPlace();
				this.goodsState=po.getGoodsState();
				String insert="INSERT INTO 中转中心到达单"+" (中转中心编号,到达日期,中转单编号,出发地,货物到达状态)"
				+" VALUES('"+transferCenterNum+"','"+arrivalDate+"','"+transferNumber+"','"+startPlace+"','"+goodsState+"')";
				mysqlimp.update(insert);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Class has some problem in ZzzxArrivalDocu!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Some MySql problem has happened in ZzzxArrivalDocu!");
			}
	}

	public void update(ZzzxArrivalDocuPO po) {
		// TODO Auto-generated method stub
		ZzzxArrivalDocu zzzx=new ZzzxArrivalDocu();
		zzzx.delete(po.getTransferNumber());
		zzzx.insert(po);
	}

	public ZzzxArrivalDocuPO find(String transferNumber) {
		// TODO Auto-generated method stub
		try {
			this.transferNumber=transferNumber;
			mysqlimp=new MySqlImp();
			String find="SELECT *"+" FROM 中转中心到达单"+" WHERE 中转单编号='"+transferNumber+"'";
			ResultSet rs=mysqlimp.query(find);
			this.transferCenterNum=rs.getString(1);
			this.arrivalDate=rs.getString(2);
			this.transferNumber=rs.getString(3);
			this.startPlace=rs.getString(4);
			this.goodsState=rs.getString(5);
			ZzzxArrivalDocuPO zzzxpo=new ZzzxArrivalDocuPO(transferCenterNum,arrivalDate,transferNumber,startPlace,goodsState);
			return zzzxpo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in ZzzxArrivalDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in ZzzxArrivalDocu!");
			return new ZzzxArrivalDocuPO("不存在","","",startPlace,goodsState);
		}
		
	}

}
