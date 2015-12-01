package AdminStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.UserInfoPO;
import userdata.UserData;

public class AdminInfoStream {
	UserData ud = new UserData();

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			if (ois.readUTF().equals("PasswordChange"))
				PasswordChange(ois, oos);
			if (ois.readUTF().equals("PowerChange"))
				PowerChange(ois, oos);
			if (ois.readUTF().equals("DeleteAcc"))
				DeleteAcc(ois, oos);
			if (ois.readUTF().equals("AddAccount"))
				AddAccount(ois,oos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void AddAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			ud.insert(up);
			oos.writeBoolean(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void PowerChange(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			if (ud.getLoginPO(up.getName()) == null) {
				oos.writeBoolean(false);
			} else {
				ud.delete(up.getName());
				oos.writeBoolean(true);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void DeleteAcc(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			if (ud.getLoginPO(up.getName()) == null) {
				oos.writeBoolean(false);
			} else {
				ud.delete(up.getName());
				oos.writeBoolean(true);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void PasswordChange(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			// TODO
			if (ud.getLoginPO(up.getName()) == null) {
				oos.writeBoolean(false);
			} else {
				ud.update(up);
				oos.writeBoolean(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
