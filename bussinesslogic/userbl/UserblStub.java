package userbl;

import java.util.ArrayList;

import userblService.UserBLService;
import vo.UserVO;

public class UserblStub implements UserBLService {

	public boolean login(long id, String password) {
		// TODO Auto-generated method stub
		return true;
	}

	public void addUser(String file) {
		// TODO Auto-generated method stub
		System.out.println("addUser Success");
	}

	public void changeUserInfo(String ID, UserVO vo) {
		// TODO Auto-generated method stub
		System.out.println("changeUserInfo Success");
	}

	public void deleteUser(String ID) {
		// TODO Auto-generated method stub
		System.out.println("deleteUser Success");
	}

	public ArrayList<UserVO> getUser(String type) {
		// TODO Auto-generated method stub
		System.out.println("getUser Success");
		return null;
	}

}
