package stubanddriverserver;

import java.util.ArrayList;

import po.UserInfoPO;
import userdataService.UserDataService;

public class UserdataStub implements UserDataService{

	public ArrayList<UserInfoPO> find(String type) {
		// TODO Auto-generated method stub
		System.out.println("find Success");
		return null;
	}

	public void insert(ArrayList<UserInfoPO> pos) {
		// TODO Auto-generated method stub
		System.out.println("insert Success");
	}

	public void delete(UserInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("delete Success");
	}

	public void update(String ID, UserInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("update Success");
	}

	public void find(UserInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("find Success");
	}

}