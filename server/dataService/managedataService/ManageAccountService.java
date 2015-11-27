package managedataService;

import po.ManageAccountPO;

public interface ManageAccountService {
		public ManageAccountPO find(String ID);
		public void insert(ManageAccountPO po);
		public void delete(String ID);
		public void update(ManageAccountPO po);
}
