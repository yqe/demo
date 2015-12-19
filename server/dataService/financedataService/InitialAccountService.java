package financedataService;

import java.util.ArrayList;

import po.InitializeAccountPO;

public interface InitialAccountService {
		public InitializeAccountPO find(String bankaccountid);
		public boolean insert(InitializeAccountPO po);
		public boolean delete(String bid);
		public ArrayList<InitializeAccountPO> findmore();
		
}
