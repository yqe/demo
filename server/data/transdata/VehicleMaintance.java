package transdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.TransPO;
import po.VehicleMaintanceInfoPO;
import transdataService.VehicleMaintanceService;

/**
 * @author jjlb
 *车辆维护信息
 */
public class VehicleMaintance implements VehicleMaintanceService {
	private String vehicleID;//车辆代号
	private String bussinessID;//营业厅编号
	private String carsID;//车牌号
	private String worktime;//服役时间
	private String driverID;//司机编号
	private String drivername;//司机姓名
	private String birthday;//出生日期
	private String idendity;//身份证号
	private String mobile;//手机号
	private String sex;//性别
	private String limittime;//行驶证期限
	MySqlImp mysqlimp;
	public VehicleMaintanceInfoPO find(String vehicleID) {
		// TODO Auto-generated method stub
		try {
			this.vehicleID=vehicleID;
			mysqlimp=new MySqlImp();
			String find="SELECT *"+" FROM 车辆维护相关信息"+" WHERE 车辆代号='"+vehicleID+"'";
			ResultSet rs=mysqlimp.query(find);
			rs.next();
			this.vehicleID=rs.getString(1);
			this.bussinessID=rs.getString(2);
			this.carsID=rs.getString(3);
			this.worktime=rs.getString(4);
			this.driverID=rs.getString(5);
			this.drivername=rs.getString(6);
			this.birthday=rs.getString(7);
			this.idendity=rs.getString(8);
			this.mobile=rs.getString(9);
			this.sex=rs.getString(10);
			this.limittime=rs.getString(11);
			VehicleMaintanceInfoPO vepo=new VehicleMaintanceInfoPO(vehicleID,bussinessID,carsID,worktime,driverID,drivername,birthday,idendity,mobile,sex,limittime);
//			System.out.println(vehicleID+"&&&"+bussinessID+carsID+worktime+driverID+drivername+birthday+idendity);
			rs.close();
			return vepo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in VehicleMaintance!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in VehicleMaintance!");
			return new VehicleMaintanceInfoPO("不存在",bussinessID,carsID,worktime,driverID,drivername,birthday,idendity,mobile,sex,limittime);
		}
		
	}

	public boolean delete(String vehicleID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 车辆维护相关信息"+" WHERE 车辆代号='"+vehicleID+"'";
			mysqlimp.update(delete);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in VehicleMaintance!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in VehicleMaintance!");
			return false;
		}
	}

	public boolean insert(VehicleMaintanceInfoPO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			this.vehicleID=po.getVehicleID();
			this.bussinessID=po.getBussinessID();
			this.carsID=po.getCarsID();
			this.worktime=po.getWorktime();
			this.driverID=po.getDriverID();
			this.drivername=po.getDrivername();
			this.birthday=po.getBirthday();
			this.idendity=po.getIdendity();
			this.mobile=po.getMobile();
			this.sex=po.getSex();
			this.limittime=po.getLimittime();
			String insert="INSERT INTO 车辆维护相关信息"+" (车辆代号,营业厅编号,车牌号,服役时间,司机编号,司机姓名,出生日期,身份证号,手机号码,性别,行驶证期限)"
			+" VALUES('"+vehicleID+"','"+bussinessID+"','"+carsID+"','"+worktime+"','"+driverID+"','"+drivername+"','"+birthday+"','"+idendity+"','"+mobile+"','"+sex+"','"+limittime+"')";
//			System.out.println(insert);
			mysqlimp.update(insert);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in VehicleMaintance!");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in VehicleMaintance!");
			return false;
		}
	}

	public boolean update(VehicleMaintanceInfoPO po) {
		// TODO Auto-generated method stub
		VehicleMaintance vehi=new VehicleMaintance();
		vehi.delete(po.getVehicleID());
		vehi.insert(po);
		return true;
	}

	public ArrayList<VehicleMaintanceInfoPO> findmore() {
		// TODO Auto-generated method stub
		ArrayList<VehicleMaintanceInfoPO> vehicleList=new ArrayList<VehicleMaintanceInfoPO>();
		try {
			mysqlimp=new MySqlImp();
			String findmore="SELECT * FROM 车辆维护相关信息";
			ResultSet rs=mysqlimp.query(findmore);
			while(rs.next()){
				vehicleList.add(new VehicleMaintanceInfoPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
			}
			rs.close();
			return vehicleList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in VehicleMaintance!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in VehicleMaintance!");
			ArrayList<VehicleMaintanceInfoPO> errvehicleList=new ArrayList<VehicleMaintanceInfoPO>();
			errvehicleList.add(new VehicleMaintanceInfoPO("不存在",bussinessID,carsID,worktime,driverID,drivername,birthday,idendity,mobile,sex,limittime));
			return errvehicleList;
		}
		
	}

}
