package financedataService;

import java.util.ArrayList;

import po.InitializeAccountPO;

public interface InitialAccountService {
		public InitializeAccountPO find(String bankaccountid);
		public void insert(InitializeAccountPO po);
		public void delete(String bid);
		public ArrayList<InitializeAccountPO> findmore();
		
}
