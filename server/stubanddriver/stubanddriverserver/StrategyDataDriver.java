package stubanddriverserver;



import java.rmi.RemoteException;

public class StrategyDataDriver {
	double weight=2.0;
	String departureplace="南京";
	String destination="北京";
    public  void drive(strategydataService.StrategyDataService StrategyDataStub) throws RemoteException{
    	StrategyDataStub.observe();
    	//trategyDataStub.calprice(weight, departureplace, destination);
    }
}
