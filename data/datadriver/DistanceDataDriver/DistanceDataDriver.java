package datadriver.DistanceDataDriver;

import java.rmi.RemoteException;

import distancedataService.DistanceDataService;

public class DistanceDataDriver {
public void drive(DistanceDataService DistanceDataStub) throws RemoteException{
	String depatureplace="南京", destination="上海";
	DistanceDataStub.caldistance(depatureplace, destination);
    }
}
