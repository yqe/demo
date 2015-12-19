package docustubanddriver;

import java.rmi.RemoteException;

import documentdataService.BussinessArrivalDocuService;
import emploeestubanddriver.EmploeeDataStub;
import po.BussinessArrivalDocuPO;
import po.EmploeePO;

public class BussArriDriver {
	public void drive(BussinessArrivalDocuService BussArriStub) throws RemoteException{
		BussinessArrivalDocuPO po=new BussinessArrivalDocuPO("2015-11-11","1111","南京","未损坏","025000");
		BussArriStub.delete("025000", "011000");
		BussArriStub.find("111", "222");
		BussArriStub.findmore("025000");
		BussArriStub.insert(po);
		BussArriStub.update(po);
	}
}
