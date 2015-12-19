package docustubanddriver;

import java.util.ArrayList;

import documentdataService.BussinessArrivalDocuService;
import po.BussinessArrivalDocuPO;

public class BussArriStub implements BussinessArrivalDocuService{

	@Override
	public boolean insert(BussinessArrivalDocuPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String transferID, String bussinessID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BussinessArrivalDocuPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BussinessArrivalDocuPO find(String ID, String bussinessID) {
		// TODO Auto-generated method stub
		BussinessArrivalDocuPO po=new BussinessArrivalDocuPO("2015-11-11","1111","南京","未损坏","025000");
		return po;
	}

	@Override
	public ArrayList<BussinessArrivalDocuPO> findmore(String bussinessID) {
		// TODO Auto-generated method stub
		ArrayList<BussinessArrivalDocuPO> list=new ArrayList<BussinessArrivalDocuPO>();
		list.add(new BussinessArrivalDocuPO("2015-11-11","1111","南京","未损坏","025000"));
		return list;
	}

}
