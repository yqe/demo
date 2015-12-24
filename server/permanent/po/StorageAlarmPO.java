package po;

public class StorageAlarmPO {
	private static final long serialVersionUID = 1L;
	/**
	 * 库存报警
	 * 
	 * @author jjlb
	 * @params
	 */
	private String transcenterID;
	private int total;// 库存总量
	private int alarmvalue;// 报警值

	public StorageAlarmPO(String ID, int total, int value) {
		this.transcenterID = ID;
		this.total = total;
		this.alarmvalue = value;
	}

	public String getTranscenterID() {
		return transcenterID;
	}

	public int getTotal() {
		return total;
	}

	public int getAlarmvalue() {
		return alarmvalue;
	}

}
