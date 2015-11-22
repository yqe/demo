/**
 * 
 */
/**
 * @author acer-pc
 *
 */

package manageblService;

public interface ManageBlService {
	public void look(long id );//查看职位信息
	public void positionTransfer(long id  ,String position); //权限调整
	public  void changePassword(long id ,String password );//修改密码
	public void cancellation(long id);//注销账户

}
