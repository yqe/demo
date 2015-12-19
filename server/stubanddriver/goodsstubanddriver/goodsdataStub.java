package goodsstubanddriver;

import java.rmi.RemoteException;

import po.GoodsPO;
import goodsdataService.GoodsDataService;

public class goodsdataStub implements GoodsDataService {

	public GoodsPO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		GoodsPO goodspo=new GoodsPO(ID);
		System.out.println("GoodsPO find Success");
		return goodspo;
	}

	public double average(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("average Success");
		double time=3;
		return time;
	}

}
