package po;

import java.io.Serializable;

//派件单
public class DiliverDocuPO implements Serializable {
	private static final long serialVersionUID = 1L;
		private String orderID;//订单条形码号
		private String arrivaltime;//到达时间/
		private String receivername;//收件人姓名
		private String courier;//派送员
		public DiliverDocuPO(String ID,String time,String name,String courier){
			this.orderID=ID;
			this.arrivaltime=time;
			this.receivername=name;
			this.courier=courier;
		}
		public String getOrderID() {
			return orderID;
		}
		public String getArrivaltime() {
			return arrivaltime;
		}
		public String getReceivername() {
			return receivername;
		}
		public String getCourier() {
			return courier;
		}
}
