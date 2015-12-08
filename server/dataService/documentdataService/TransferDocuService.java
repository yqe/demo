package documentdataService;

import java.util.ArrayList;

import po.TransferDocuPO;

public interface TransferDocuService {
		public ArrayList<TransferDocuPO> findall(String transcenterID);
		
		public void delete(String goodsID);
		
		public void insert(TransferDocuPO po);
		
		public void update(TransferDocuPO po);
		public TransferDocuPO find(String carryNumber);
}
