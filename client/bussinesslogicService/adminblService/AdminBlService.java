/**
 * 
 */
/**
 * @author acer-pc
 *
 */

package adminblService;

import po.UserInfoPO;

public interface AdminBlService {
	
	public UserInfoPO look(long id);// 查看职位信息

	public boolean positionTransfer(UserInfoPO upo); // 权限调整

	public boolean changePassword(UserInfoPO upo);// 修改密码

	public boolean cancellation(UserInfoPO upo);// 注销账户

}
