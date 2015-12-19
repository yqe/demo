package financestubanddriver;

import java.util.ArrayList;

import financedataService.InitialAccountService;
import po.InitializeAccountPO;

public class FinanceDataStub implements InitialAccountService {

	@Override
	public InitializeAccountPO find(String bankaccountid) {
		// TODO Auto-generated method stub
		InitializeAccountPO po=new InitializeAccountPO("333", "233", 1, 2, 3, 4);
		return po;
	}

	@Override
	public boolean insert(InitializeAccountPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(String bid) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<InitializeAccountPO> findmore() {
		// TODO Auto-generated method stub
		ArrayList<InitializeAccountPO> list=new ArrayList<InitializeAccountPO>();
		list.add(new InitializeAccountPO("333", "233", 1, 2, 3, 4));
		return list;
	}


	
}
