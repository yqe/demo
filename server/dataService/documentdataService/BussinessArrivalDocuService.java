package documentdataService;

import java.util.ArrayList;

import po.BussinessArrivalDocuPO;

public interface BussinessArrivalDocuService {
		public boolean insert(BussinessArrivalDocuPO po);
		public boolean delete(String transferID,String bussinessID);
		public boolean update(BussinessArrivalDocuPO po);
		public BussinessArrivalDocuPO find(String ID,String bussinessID);
		public ArrayList<BussinessArrivalDocuPO> findmore(String bussinessID);
		
		
}
