package documentbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.EarnedPO;
import po.EarnedPOList;

public class Earneddocu {

	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	boolean IsOk;
	String hostid = "localhost";

	public Earneddocu(ObjectOutputStream oos, ObjectInputStream ois) {
		this.ois = ois;
		this.oos = oos;
	}

	/**
	 * 得到所给日期之间的所有收款单 如果是按ID查询 那么data1=="ID",则datar就是营业厅text的值;为得到所给营业厅ID的所有收款单
	 * 如果是按日期查询 那么data1=="day",则datar就是所选择的日期,为得到所给日期当天的所有收款单;
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	@SuppressWarnings("unchecked")
	public EarnedPOList GetEarnedDocu(String datal, String datar) {
		EarnedPOList epolist = null;
		try {
			oos.writeUTF("Finance");
			oos.writeUTF("GetEarnedDocu");
			oos.writeObject(new String(datal + " " + datar));
			epolist = (EarnedPOList) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return epolist;
	}

	/**
	 * 建立收款单
	 * 
	 * @param EarnedPO
	 *            earnpo;
	 * @return
	 * @exception @author
	 *                zxc
	 */
	public boolean BuildEarnedDocu(EarnedPO earnpo) {
		IsOk = false;
		try {
			oos.writeUTF("HallClerk");
			oos.writeUTF("ReceiveBill");
			oos.writeObject(earnpo);
			IsOk = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
}
