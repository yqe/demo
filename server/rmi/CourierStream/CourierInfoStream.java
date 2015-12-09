package CourierStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import distancedata.DistanceData;
import documentdata.DiliverDocu;
import documentdata.GoodsDocu;
import goodsdata.ExpressTrail;
import po.DiliverDocuPO;
import po.ExpressTrailPO;
import po.GoodsDocuPO;
import strategydata.StrategyData;

public class CourierInfoStream {

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "SendBill":
				SendBill(ois, oos);
				break;
			case "DeliveryBill":
				DeliveryBill(ois, oos);
				break;
			case "QueryOrder":
				QueryOrder(ois, oos);
				break;
			case "AboutPrice":
				AboutPrice(ois, oos);
				break;
			case "GetRoute":
				GetRoute(ois, oos);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回给客户端快递的货运轨迹;
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void GetRoute(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			ExpressTrail trail = new ExpressTrail();
			String goodid= (String) ois.readObject();
			ExpressTrailPO trailpo = trail.find(goodid);
			oos.writeObject(trailpo);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 返回给客户端价格相关的常量;
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void AboutPrice(ObjectInputStream ois, ObjectOutputStream oos) {
		DistanceData disdata = new DistanceData();
		StrategyData strdata = new StrategyData();
		try {
			double re = 0.0;
			String[] cityn = ((String) ois.readObject()).split(" ");
			re = disdata.getdistance(cityn[0], cityn[1]) * strdata.getconstance();
			oos.writeObject(new Double(re));
			System.out.println(re);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查询订单
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void QueryOrder(ObjectInputStream ois, ObjectOutputStream oos) {
		GoodsDocu gd = new GoodsDocu();
		try {
			String goodid = (String) ois.readObject();
			GoodsDocuPO gdpo = gd.find(goodid);
			oos.writeObject(gdpo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 派件单
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void DeliveryBill(ObjectInputStream ois, ObjectOutputStream oos) {
		DiliverDocu ddp = new DiliverDocu();
		try {
			DiliverDocuPO gdpo = (DiliverDocuPO) ois.readObject();
			ddp.insert(gdpo);
			oos.writeBoolean(true);
			oos.writeObject(new Boolean(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 快递单
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos
	 * @exception @author
	 *                zxc
	 */
	private void SendBill(ObjectInputStream ois, ObjectOutputStream oos) {
		GoodsDocu gd = new GoodsDocu();
		try {
			GoodsDocuPO gdpo = (GoodsDocuPO) ois.readObject();
			gd.insert(gdpo);
			oos.writeObject(new Boolean(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
