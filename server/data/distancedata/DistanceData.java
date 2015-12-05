package distancedata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import distancedataService.DistanceDataService;
import mysqlimp.MySqlImp;
import po.DistancePO;

public class DistanceData implements DistanceDataService{
		private MySqlImp mysqlimp;
		private double distance;//距离
		private String departureplace;//出发地
		private String destination;//目的地
	public DistancePO getdistance(String departureplace, String destination) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			this.departureplace=departureplace;
			this.destination=destination;
			mysqlimp=new MySqlImp();
			String finddistance="SELECT 距离"+" FROM 城市距离"+" WHERE 出发地='"+departureplace+"' and 目的地='"+destination+"'";
			ResultSet rs=mysqlimp.query(finddistance);
			rs.next();
			distance=rs.getDouble(1);
			//System.out.println(distance);
			DistancePO dispo=new DistancePO(departureplace,destination,distance);
			return dispo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in getdistance!");
			return new DistancePO("不存在","",0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in getdistance!");
			return new DistancePO("不存在","",0);
		}
			
	}

}
