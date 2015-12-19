package userstubanddriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserInfoPO;
import userdataService.UserDataService;

public class UserDataDriver {
	public void drive(UserDataService userdataStub) throws RemoteException{
		UserInfoPO po=new UserInfoPO("111","222","333","ggg");
		userdataStub.delete("111");
		userdataStub.getLoginPO("2222");
		userdataStub.insert(po);
		userdataStub.update(po);

    }
}
