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
}