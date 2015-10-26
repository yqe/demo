/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package userdataService;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserInfoPO;
public interface UserDataService{
	public ArrayList<UserInfoPO> find(String type);//按ID进行查找返回相应的UserInfoPO结果
	public void insert(ArrayList<UserInfoPO> pos);//在数据文件中增加一个po记录
	public void delete(UserInfoPO po);//删除一个po
	public void update(String ID, UserInfoPO po);//更新一个po
	public void find(UserInfoPO po);//按ID进行查找返回相应的UserLoginPO结果
}