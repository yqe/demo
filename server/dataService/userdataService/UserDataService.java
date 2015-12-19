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
		public boolean delete(String ID);
		public boolean insert(UserInfoPO po);
		public boolean update(UserInfoPO po);
}