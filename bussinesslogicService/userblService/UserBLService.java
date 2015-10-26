
package userblService;

import java.util.ArrayList;

import vo.UserVO;

public interface UserBLService{
    public boolean login(long id,String password);//查找是否存在相应的User
	public void addUser(String file);//将文件的用户导入，创建相关用户
	public void changeUserInfo(String ID,UserVO vo);//修改相关用户信息
	public void deleteUser(String ID);//系统删除相关用户
	public ArrayList<UserVO> getUser(String type);//用户查询相关类型的用户，并返回
}