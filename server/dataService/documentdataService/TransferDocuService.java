package documentdataService;

import java.util.ArrayList;

import po.TransferDocuPO;

public interface TransferDocuService {
		public ArrayList<TransferDocuPO> findall(String transcenterID);
		
		public boolean delete(String goodsID);
		
		public boolean insert(TransferDocuPO po);
		
		public boolean update(TransferDocuPO po);
		public TransferDocuPO find(String carryNumber);
		
}
