package stubanddriverserver;

import java.rmi.RemoteException;

import distancedataService.DistanceDataService;
import po.DistancePO;

public class DistancedataStub implements DistanceDataService{

	public DistancePO getdistance(String depatureplace, String destination)
			throws RemoteException {
		// TODO Auto-generated method stub
		double distance=100;
		System.out.println("caldistance Success");
		DistancePO dis=new DistancePO("jj","dge",2000.1);
		return dis;
	}

}
