package financestubanddriver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.InitializeAccountPO;
import po.DocumentPO;

public class FinanceDataDriver {
	public void drive(FinanceDataStub FinanceDataStub) throws RemoteException {
		InitializeAccountPO id1 = new InitializeAccountPO("111", "111", 1, 1, 1, 2);
		FinanceDataStub.delete("111");
		FinanceDataStub.find("111");
		FinanceDataStub.findmore();
		FinanceDataStub.insert(id1);
	}
}
