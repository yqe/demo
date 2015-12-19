package userstubanddriver;

import java.util.ArrayList;

import po.UserInfoPO;
import userdataService.UserDataService;

public class UserdataStub implements UserDataService{

	@Override
	public UserInfoPO getLoginPO(String name) {
		// TODO Auto-generated method stub
		UserInfoPO po=new UserInfoPO("111","222","333","ggg");
		return po;
	}

	@Override
	public boolean delete(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(UserInfoPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserInfoPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
