package po;

import java.io.Serializable;

public class CostManagePO implements Serializable {
	private static final long serialVersionUID = 1L;
    private String date;//付款日期
    private double payment;//付款金额
    private  String payer;//付款人
    private  String payaccount;//付款账号
    private String tiaomu;//条目
    private String tip;//备注
    public CostManagePO(String date,double payment,String payer,String payaccount,String tiaomu,String tip){
    	this.date=date;
    	this.payment=payment;
    	this.payer=payer;
    	this.payaccount=payaccount;
    	this.tiaomu=tiaomu;
    	this.tip=tip;
    }
	public String getDate() {
		return date;
	}
	public double getPayment() {
		return payment;
	}
	public String getPayer() {
		return payer;
	}
	public String getPayaccount() {
		return payaccount;
	}
	public String getTiaomu() {
		return tiaomu;
	}
	public String getTip() {
		return tip;
	}
	
   
      
}
