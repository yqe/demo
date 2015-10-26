package datadriver.GoodsDataDriver;

import java.rmi.RemoteException;

import po.GoodsPO;
import goodsdataService.GoodsDataService;


public class GoodsDataDriver {
public void drive(GoodsDataService goodsdataStub) throws RemoteException{
		String ID="123456";
		goodsdataStub.find(ID);
		GoodsPO po=new GoodsPO(ID);
		goodsdataStub.average(po);
    }
}
