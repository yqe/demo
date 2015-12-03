package documentdataService;

import java.util.ArrayList;

import po.BussinessArrivalDocuPO;

public interface BussinessArrivalDocuService {
		public void insert(BussinessArrivalDocuPO po,String busssinessID);
		public void delete(String transferID,String bussinessID);
		public void update(BussinessArrivalDocuPO po,String busssinessID);
		public BussinessArrivalDocuPO find(String ID,String bussinessID);
		public ArrayList<BussinessArrivalDocuPO> findmore(String bussinessID);
}
