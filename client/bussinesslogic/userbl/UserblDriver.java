package userbl;

import userblService.UserBLService;
import vo.UserVO;


public class UserblDriver {
	public void drive(UserBLService userblstub){
	    String file="123",ID="321",password="12345646",type="151";
	    long id=4566;
	    UserVO vo=new UserVO();
		userblstub.addUser(file);
		userblstub.changeUserInfo(ID, vo);
		userblstub.deleteUser(ID);
		if(userblstub.login(id, password)){
			System.out.println("login Success");
		}
		userblstub.getUser(type);
		
	}
}
