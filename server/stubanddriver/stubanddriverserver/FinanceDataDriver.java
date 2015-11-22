package stubanddriverserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import financedataService.FinanceDataService;
import po.AccountPO;
import po.DocumentPO;

public class FinanceDataDriver {
   public void drive(FinanceDataStub FinanceDataStub) throws RemoteException{
      AccountPO id1=new  AccountPO();
      
      AccountPO id2=new  AccountPO();
      AccountPO id3=new  AccountPO();
      AccountPO id4=new  AccountPO();
      long id=1234552;
      ArrayList<DocumentPO> a=new ArrayList();
      FinanceDataStub.add(id1);
      FinanceDataStub.delete(id2);
      FinanceDataStub.update(id3);
      FinanceDataStub.find(id);
      FinanceDataStub.calculate(a);
      
   }
   }
