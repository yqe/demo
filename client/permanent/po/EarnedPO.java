package po;

import java.io.Serializable;

public class EarnedPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String paydate;//付款日期
	private double earnedmoney;//收款金额
	private String dilivername;//收款快递员姓名
	private String orderID;//订单条形码号
	private String bussinessID;//所属营业厅编号
	
	public EarnedPO(String paydate,double money,String dname,String ID,String buID){
		this.paydate=paydate;//收款日期
		this.earnedmoney=money;//收款金额
		this.dilivername=dname;//收款快递员姓名
		this.orderID=ID;//订单条形码号
		this.bussinessID=buID;//所属营业厅ID
	}

	public String getPaydate() {
		return paydate;
	}

	public double getEarnedmoney() {
		return earnedmoney;
	}

	public String getDilivername() {
		return dilivername;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getBussinessID() {
		return bussinessID;
	}
	
}
