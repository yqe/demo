package po;

import java.io.Serializable;
/**
 * 中转单
 * @author jjlb
 *
 */
public class TransferDocuPO implements Serializable{
	private static final long serialVersionUID = 1L;
	 private String transportType;//交通工具种类
	 private String date;//装车日期
	 private String transferNumber;//本中转单编号
	 private String flightNumber;//航班号
	 private String startPlace;//出发地
	 private String destination;//目的地
	 private String goodsNumber;//货柜号
	 private String monitor;//监装员
	 private String carryNumber;//本次装箱托运单号
	 private double money;
	 public TransferDocuPO(String transportType,String date ,
			 String transferNumber, String flightNumber,
			 String startPlace,	 String destination,String goodsNumber,
			 String monitor,String carryNumber,double money	)
		 {
		     this.transportType=transportType;
		     this.date=date;
		     this.transferNumber=transferNumber;
		     this.flightNumber=flightNumber;
		     this.startPlace=startPlace;
		     this.destination=destination;
		     this.goodsNumber=goodsNumber;
		     this.monitor=monitor;
		     this.carryNumber=carryNumber;
		     this.money=money;
		 }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTransportType() {
		return transportType;
	}
	public String getDate() {
		return date;
	}
	public String getTransferNumber() {
		return transferNumber;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public String getDestination() {
		return destination;
	}
	public String getGoodsNumber() {
		return goodsNumber;
	}
	public String getMonitor() {
		return monitor;
	}
	public String getCarryNumber() {
		return carryNumber;
	}
	public double getMoney() {
		return money;
	}


}
