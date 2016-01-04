package po;

import java.io.Serializable;

public class StorageAlarmPO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 库存报警
	 * 
	 * @author jjlb
	 * @params
	 */
	private String transcenterID;
	private int total;// 库存总量
	private double alarmvalue;// 报警值

	public StorageAlarmPO(String ID, int total, double alarmvalue2) {
		this.transcenterID = ID;
		this.total = total;
		this.alarmvalue = alarmvalue2;
	}

	public String getTranscenterID() {
		return transcenterID;
	}

	public int getTotal() {
		return total;
	}

	public double getAlarmvalue() {
		return alarmvalue;
	}

}
