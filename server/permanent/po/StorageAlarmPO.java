package po;

public class StorageAlarmPO {
	/**
	 * 库存报警
	 * @author jjlb
	 * @params
	 */
	private String transcenterID;
	private int total;//库存总量
	private double alarmvalue;//报警值

	public StorageAlarmPO(String ID, int total, double value) {
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

	public double getAlarmvalue() {
		return alarmvalue;
	}

}
