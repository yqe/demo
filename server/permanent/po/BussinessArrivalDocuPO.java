package po;

public class BussinessArrivalDocuPO {
	//营业厅到达单
	private String arrivaltime;//到达日期
	private String transferID;//中转编号
	private String destination;//目的地
	private String state;//到达状态
	public BussinessArrivalDocuPO(String atime,String ID,String des,String state){
		this.arrivaltime=atime;
		this.transferID=ID;
		this.destination=des;
		this.state=state;
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
