/**
 * 
 */
/**
 * @author jjlb
 *
 */
package emploeebl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import emploeeblService.EmploeeBlService;
import po.EmploeePO;
import vo.EmploeeVO;

public class EmploeeBl implements EmploeeBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String hostid = "localhost";
	/**
	 * 根据ID得到一个员工信息
	 * 
	 * @paramString ID;
	 * @return EmploeePO;
	 * @exception @author
	 *                zxc
	 */
	public EmploeePO IDGetEmp(String ID) {
		EmploeePO empo=null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("IDGetEmployeeInfo");
			oos.writeObject(new String(ID));
			empo=(EmploeePO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empo;
	}
	/**
	 * 根据机构得到此机构所有员工信息
	 * 
	 * @param String oname;
	 * @return ArrayList<EmploeePO>;
	 * @exception @author
	 *                zxc
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<EmploeePO> GetOEmployee(String oname) {
		ArrayList<EmploeePO> empolist=null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("GetOEmployee");
			oos.writeObject(new String(oname));
			empolist=(ArrayList<EmploeePO>) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empolist;
	}
	/**
	 * 根据ID修改员工信息;
	 * @param EmploeePO empo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean ModifyEmpInfo(EmploeePO empo) {
		boolean IsOk=false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("ModifyEmpInfo");
			oos.writeObject(empo);
			IsOk=(boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
	/**
	 * 增加员工信息
	 * @param EmploeePO empo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean AddEmpInfo(EmploeePO empo) {
		boolean IsOk=false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("AddEmpInfo");
			oos.writeObject(empo);
			IsOk=(boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
	/**
	 * 根据ID删除一个员工的信息
	 * @param EmploeePO empo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean DeleteEmp(String ID) {
		boolean IsOk=false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("DeleteEmpInfo");
			oos.writeObject(new String(ID));
			IsOk=(boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}