
/**
 * @author acer-pc
 *
 */

package userbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import po.UserInfoPO;
import userblService.UserBlService;

public class UserBl implements UserBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String hostid = "localhost";

	// 根据id查找用户信息
	public String look(String id, String password) {
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("GetAccount");
			oos.writeObject(new UserInfoPO(id, password, "", ""));
			UserInfoPO upo = (UserInfoPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
			if (password.equals(upo.getPassword()))
				return upo.getPosition();
			else if (upo == null)
				return "NoAccount";//无账户
			else
				return "PasswordError";//密码错误
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 权限调整
	public boolean positionTransfer(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
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
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("PasswordChange");
			oos.writeObject(upo);
			IsOk = ois.readBoolean();
			System.out.println(IsOk);
			ois.close();
			oos.close();
			socket.close();
			return IsOk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	// 注销账户
	public boolean cancellation(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
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
