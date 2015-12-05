package po;

import java.io.Serializable;
/**
 * 营业厅到达单
 * @author jjlb
 *
 */
public class BussinessArrivalDocuPO implements Serializable {
	private static final long serialVersionUID = 1L;
	//营业厅到达单
	private String bussinessID;//营业厅编号
	private String arrivaltime;//到达日期
	private String transferID;//中转编号
	private String destination;//目的地
	private String state;//到达状态
	public BussinessArrivalDocuPO(String atime,String ID,String des,String state,String bussinessID){
		this.bussinessID=bussinessID;
		this.arrivaltime=atime;
		this.transferID=ID;
		this.destination=des;
		this.state=state;
	}
	public String getBussinessID() {
		return bussinessID;
	}
	public String getArrivaltime() {
		return arrivaltime;
	}
	public String getTransferID() {
		return transferID;
	}
	public String getDestination() {
		return destination;
	}
	public String getState() {
		return state;
	}
}
