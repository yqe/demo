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
		public UserInfoPO getLoginPO(String name);
		public void delete(String ID);
		public void insert(UserInfoPO po);
		public void update(UserInfoPO po);
}