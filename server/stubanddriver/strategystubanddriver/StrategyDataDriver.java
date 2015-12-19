package strategystubanddriver;



import java.rmi.RemoteException;

import po.StrategyPO;

public class StrategyDataDriver {
	double weight=2.0;
	String departureplace="南京";
	String destination="北京";
    public  void drive(strategydataService.StrategyDataService StrategyDataStub) throws RemoteException{
    	StrategyDataStub.observe();
    	StrategyDataStub.updateconstant(1);
    	StrategyDataStub.updatesalary(new StrategyPO(1,2,3,4,5,6,7,8));
    }
}
