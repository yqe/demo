/**
 * 
 */
/**
 * @author acer-pc
 *
 */

package adminbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import adminblService.AdminBlService;
import po.UserInfoPO;

public class AdminBl implements AdminBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	// 查看职位信息
	public UserInfoPO look(long id) {
		try {
			socket = new Socket("localhost", 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("GetAccount");
			UserInfoPO upo = (UserInfoPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
			return upo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 权限调整
	public boolean positionTransfer(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket("localhost", 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("PowerChange");
			oos.writeObject(upo);
			IsOk = ois.readBoolean();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	// 修改密码
	public boolean changePassword(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket("localhost", 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("PasswordChange");
			oos.writeObject(upo);
			IsOk = ois.readBoolean();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	// 注销账户
	public boolean cancellation(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket("localhost", 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("DeleteAcc");
			oos.writeObject(upo);
			IsOk = ois.readBoolean();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

}
