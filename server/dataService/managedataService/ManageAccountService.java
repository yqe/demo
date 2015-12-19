package managedataService;

import po.ManageAccountPO;

public interface ManageAccountService {
		public ManageAccountPO find(String ID);
		public boolean insert(ManageAccountPO po);
		public boolean delete(String ID);
		public boolean update(ManageAccountPO po);
}
