package strategybl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.StrategyPO;
import strategyblService.StrategyBlService;

public class StrategyBl implements StrategyBlService {

	ObjectOutputStream oos;
	ObjectInputStream ois;

	public StrategyBl(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos = oos;
		this.ois = ois;
	}

	/**
	 * 经营策略查看
	 * 
	 * @param
	 * @return StrategyPO;
	 * @exception @author
	 *                zxc
	 */
	public StrategyPO show() {
		StrategyPO spolist = null;
		try {
			oos.writeUTF("Manager");
			oos.writeUTF("ShowStrategy");
			oos.writeObject(new String("OK"));
			spolist = (StrategyPO) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spolist;
	}

	/**
	 * 经营策略查看
	 * 
	 * @param trategyPO
	 *            spo
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean modify(StrategyPO spo) {
		boolean IsOk = false;
		try {
			oos.writeUTF("Manager");
			oos.writeUTF("FormulateStrategy");
			oos.writeObject(new String("OK"));
			oos.writeObject(spo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	public double calPrice(double weight, String depatureplace, String destination, String type) {
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
