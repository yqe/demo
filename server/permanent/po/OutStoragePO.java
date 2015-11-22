package po;

import java.io.Serializable;

public class OutStoragePO implements Serializable{
	private static final long serialVersionUID = 1L;
	/* 快递编号 */
	public String goodno;
	/* 出库日期 */
	public String outtime;
	/* 目的地 */
	public String destination;
	/* 装运形式 */
	public String loadform;
	/* 中转单编号or汽运编号 */
	public String transferno;
	public OutStoragePO(String goodno,String outtime,String destination,String loadform,String transferno) {
		this.goodno=goodno;
		this.outtime=outtime;
		this.destination=destination;
		this.loadform=loadform;
		this.transferno=transferno;
	}
	public String getGoodno() {
		return goodno;
	}
	public String getOuttime() {
		return outtime;
	}
	public String getDestination() {
		return destination;
	}
	public String getLoadform() {
		return loadform;
	}
	public String getTransferno() {
		return transferno;
	}

}
