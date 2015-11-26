package distancedata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import distancedataService.DistanceDataService;
import mysqlimp.MySqlImp;

public class DistanceData implements DistanceDataService{
		private MySqlImp mysqlimp;
		private double distance;
		
	public double getdistance(String departureplace, String destination) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String finddistance="SELECT 距离"+" FROM 城市距离"+" WHERE 出发地='"+departureplace+"' and 目的地='"+destination+"'";
			ResultSet rs=mysqlimp.query(finddistance);
			rs.next();
			distance=rs.getDouble(1);
			//System.out.println(distance);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return distance;
	}

}
