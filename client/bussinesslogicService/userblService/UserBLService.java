/**
 * 
 */
/**
 * @author acer-pc
 *
 */

package userblService;

import po.UserInfoPO;

public interface UserBlService {
	
	public String look(String id,String password);// 查看职位信息

	public boolean positionTransfer(UserInfoPO upo); // 权限调整

	public boolean changePassword(UserInfoPO upo);// 修改密码

	public boolean cancellation(UserInfoPO upo);// 注销账户

}
