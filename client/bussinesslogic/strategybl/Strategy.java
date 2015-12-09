package strategybl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.StrategyPO;
import strategyblService.StrategyBlService;

public class Strategy implements StrategyBlService{
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String hostid="localhost";
	/**
	 * 经营策略查看
	 * @param 
	 * @return StrategyPO;
	 * @exception @author
	 *                zxc
	 */
	public StrategyPO show() {
		StrategyPO spolist=null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("ShowStrategy");
			spolist = (StrategyPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spolist;
	}
	/**
	 * 经营策略查看
	 * @param trategyPO spo
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean modify(StrategyPO spo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Manager");
			oos.writeUTF("FormulateStrategy");
			oos.writeObject(spo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("StorageBl.InStorageInputSuccess");
		return IsOk;
	}

	public double calPrice(double weight, String depatureplace,
			String destination, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean modifyDistance(String city, Double distance) {
		// TODO Auto-generated method stub
		return false;
	}

	public void observe(String stra) {
		// TODO Auto-generated method stub
		
	}
	public boolean modifySalary(StrategyPO spo) {
		// TODO Auto-generated method stub
		return false;
	}


}
