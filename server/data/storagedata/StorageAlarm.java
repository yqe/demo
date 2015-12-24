package storagedata;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlimp.MySqlImp;
import po.StorageAlarmPO;
import storagedataService.StorageAlarmService;

/**
 * @author jjlb
 * 库存报警
 */

public class StorageAlarm implements StorageAlarmService{
	private String transcenterID;
	private int total;//库存总量
	private double alarmvalue;//报警值
	MySqlImp mysqlimp;
	
	@Override
	public boolean insert(StorageAlarmPO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			this.transcenterID=po.getTranscenterID();
			this.total=po.getTotal();
			this.alarmvalue=po.getAlarmvalue();
			String insert="INSERT INTO 库存报警"+" (中转中心编号,库存可容纳量,库存报警值)"+" VALUES('"+transcenterID+"',"+total+","+alarmvalue+")";
			mysqlimp.update(insert);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(String transcenterID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 库存报警"+" WHERE 中转中心编号='"+transcenterID+"'";
			mysqlimp.update(delete);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public StorageAlarmPO find(String transcenterID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String find="SELECT * FROM 库存报警"+" WHERE 中转中心编号='"+transcenterID+"'";
			ResultSet rs=mysqlimp.query(find);
			rs.next();
			this.transcenterID=rs.getString(1);
			this.total=rs.getInt(2);
			this.alarmvalue=rs.getDouble(3);
			StorageAlarmPO alaempo=new StorageAlarmPO(transcenterID,total,alarmvalue);
			return alaempo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StorageAlarmPO alaempo=new StorageAlarmPO("不存在",total,alarmvalue);
			return alaempo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StorageAlarmPO alaempo=new StorageAlarmPO("不存在",total,alarmvalue);
			return alaempo;
		}
	}

	@Override
	public boolean update(StorageAlarmPO po) {
		// TODO Auto-generated method stub
		this.delete(po.getTranscenterID());
		this.insert(po);
		return true;
	}

}
