package stubanddriverserver;

import java.rmi.RemoteException;

import distancedataService.DistanceDataService;

public class DistancedataStub implements DistanceDataService{

	public double getdistance(String depatureplace, String destination)
			throws RemoteException {
		// TODO Auto-generated method stub
		double distance=100;
		System.out.println("caldistance Success");
		return distance;
	}

}
