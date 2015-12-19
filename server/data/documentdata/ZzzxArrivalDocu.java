package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.ZzzxArrivalDocuService;
import mysqlimp.MySqlImp;
import po.CondemnDocuPO;
import po.TransPO;
import po.ZzzxArrivalDocuPO;

/**
 * @author jjlb
 *中转中心到达单
 */
public class ZzzxArrivalDocu implements ZzzxArrivalDocuService{
	private String transferCenterNum;//中转中心编号
	private String arrivalDate;
	private String transferNumber;//中转单编号
	private String startPlace;//出发地
	private String goodsState;//货物到达状态
	MySqlImp mysqlimp;
	//根据中转中心编号返回所有该中转中心到达单
	public ArrayList<ZzzxArrivalDocuPO> findall(String transID) {
		// TODO Auto-generated method stub
		ArrayList<ZzzxArrivalDocuPO> zzzxpo=new ArrayList<ZzzxArrivalDocuPO>();
		try {
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM 中转中心到达单"+" WHERE 中转中心编号='"+transID+"'";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				this.transferCenterNum=rs.getString(1);
				this.arrivalDate=rs.getString(2);
				this.transferNumber=rs.getString(3);
				this.startPlace=rs.getString(4);
				this.goodsState=rs.getString(5);
				zzzxpo.add(new ZzzxArrivalDocuPO(transferCenterNum,arrivalDate,transferNumber,startPlace,goodsState));
			}
			rs.close();
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
			ArrayList<ZzzxArrivalDocuPO> zzzxpoList=new ArrayList<ZzzxArrivalDocuPO>();
			zzzxpoList.add(new ZzzxArrivalDocuPO("不存在","","",startPlace,goodsState));
			return zzzxpoList;
		}
		
	}

	public boolean delete(String goodsID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 中转中心到达单"+" WHERE 中转单编号='"+goodsID+"'";
			mysqlimp.update(delete);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in ZzzxArrivalDocu!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in ZzzxArrivalDocu!");
			return false;
		}
	}

	public boolean insert(ZzzxArrivalDocuPO po) {
		// TODO Auto-generated method stub
		CondemnDocu condocu=new CondemnDocu();
		try {
				mysqlimp=new MySqlImp();
				this.transferCenterNum=po.getTransferCenterNum();
				this.arrivalDate=po.getArrivalDate();
				this.transferNumber=po.getTransferNumber();
				this.startPlace=po.getStartPlace();
				this.goodsState=po.getGoodsState();
				condocu.insert(new CondemnDocuPO("中转中心到达单", transferNumber, "未审批"));
				String insert="INSERT INTO 中转中心到达单"+" (中转中心编号,到达日期,中转单编号,出发地,货物到达状态)"
				+" VALUES('"+transferCenterNum+"','"+arrivalDate+"','"+transferNumber+"','"+startPlace+"','"+goodsState+"')";
				mysqlimp.update(insert);
				return true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Class has some problem in ZzzxArrivalDocu!");
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Some MySql problem has happened in ZzzxArrivalDocu!");
				return false;
			}
	}

	public boolean update(ZzzxArrivalDocuPO po) {
		// TODO Auto-generated method stub
		ZzzxArrivalDocu zzzx=new ZzzxArrivalDocu();
		zzzx.delete(po.getTransferNumber());
		zzzx.insert(po);
		return true;
	}

	//返回一个中转中心到达单
	public ZzzxArrivalDocuPO find(String transferNumber,String transID) {
		// TODO Auto-generated method stub
		try {
			this.transferNumber=transferNumber;
			mysqlimp=new MySqlImp();
			String find="SELECT *"+" FROM 中转中心到达单"+" WHERE 中转单编号='"+transferNumber+"' and WHERE 中转中心编号='"+transID+"'";
			ResultSet rs=mysqlimp.query(find);
			this.transferCenterNum=rs.getString(1);
			this.arrivalDate=rs.getString(2);
			this.transferNumber=rs.getString(3);
			this.startPlace=rs.getString(4);
			this.goodsState=rs.getString(5);
			ZzzxArrivalDocuPO zzzxpo=new ZzzxArrivalDocuPO(transferCenterNum,arrivalDate,transferNumber,startPlace,goodsState);
			rs.close();
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