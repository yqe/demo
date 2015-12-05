package po;

import java.io.Serializable;
/**
 * 装车单
 * @author jjlb
 *
 */
public class TransPO implements Serializable {
	private static final long serialVersionUID = 1L;
		private String date;//装车日期
		private String bussinessID;//本营业厅编号
		private String expreID;//汽运编号
		private String destination;//到达地
		private String carsID;//车辆代号
		private String monitor;//监装员
		private String supercargo;//押运员
		private double fee;//运费
		private String orderID;//装箱里的订单号
   public TransPO(String date,String bussID,String exID,String desti,String carID,String moni,String supercar,double fee,String order){
	   	this.date=date;
	   	this.bussinessID=bussID;
	   	this.expreID=exID;
	   	this.destination=desti;
	   	this.carsID=carID;
	   	this.monitor=moni;
	   	this.supercargo=supercar;
	   	this.fee=fee;
	   	this.orderID=order;
   }
   public String getDate() {
	return date;
}
   public String getBussinessID() {
	return bussinessID;
}
   public String getExpreID() {
	return expreID;
}
   public String getDestination() {
	return destination;
}
   public String getCarsID() {
	return carsID;
}
   public String getMonitor() {
	return monitor;
}
   public String getSupercargo() {
	return supercargo;
}
   public double getFee() {
	return fee;
}
   public String getOrderID() {
	return orderID;
}
	
	
	
}
