package po;

import java.io.Serializable;

public class ZzzxArrivalDocuPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String transferCenterNum;//中转中心编号
	private String arrivalDate;
	private String transferNumber;//中转单编号
	private String startPlace;//出发地
	private String goodsState;//货物到达状态
	public ZzzxArrivalDocuPO(String transferCenterNum,String arrivalDate,String transferNumber,
			String startPlace,String goodsState){
		this.transferCenterNum=transferCenterNum;
		this.arrivalDate=arrivalDate;
		this.transferNumber=transferNumber;
		this.startPlace=startPlace;
		this.goodsState=goodsState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTransferCenterNum() {
		return transferCenterNum;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public String getTransferNumber() {
		return transferNumber;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public String getGoodsState() {
		return goodsState;
	}

}
