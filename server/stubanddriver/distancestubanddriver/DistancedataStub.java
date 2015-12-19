package distancestubanddriver;

import java.rmi.RemoteException;

import distancedataService.DistanceDataService;
import po.DistancePO;

public class DistancedataStub implements DistanceDataService{

	public double getdistance(String depatureplace, String destination)
			throws RemoteException {
		// TODO Auto-generated method stub
		double distance=100;
		return distance;
	}

}
