package stubanddriverserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserInfoPO;
import userdataService.UserDataService;

public class UserDataDriver {
	public void drive(UserDataService userdataStub) throws RemoteException{
		UserInfoPO po=new UserInfoPO();
		String type ="12315",ID="12316";
		userdataStub.delete(po);
		userdataStub.find(type);
		userdataStub.find(po);
		ArrayList<UserInfoPO> pos=new ArrayList();
		userdataStub.insert(pos);
		userdataStub.update(ID, po);

    }
}
