package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import po.CondemnList;
import vo.DocumentVO;
import documentblService.DocumentBlService;

public class DocumentBl implements DocumentBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	/**
	 * 返回未审批的单据
	 * 
	 * @param
	 * @return ArrayList<CondemnDocuPO>
	 * @exception @author
	 *                zxc
	 */
	public CondemnList GetUnapproveBill() {
		CondemnList cdpolist = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("GetUnapproveBill");
			oos.writeObject(new String("OK"));
			cdpolist = (CondemnList) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cdpolist;

	}

	/**
	 * 批量审批单据
	 * 
	 * @param
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean ApproveBill() {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("ApproveBill");
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;

	}

	public boolean choose(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<DocumentVO> getDo(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modifyinfo(String ID, DocumentVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteDo(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

	public DocumentVO show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocumentVO> add(String type, String[] info) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocumentVO> inputPri(String begin, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean generate(Infocollector infoco) {

		return true;
	}

}
