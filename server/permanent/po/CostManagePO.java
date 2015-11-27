package po;

import java.io.Serializable;

public class CostManagePO implements Serializable {
	private static final long serialVersionUID = 1L;
    private String date;//付款日期
    private double payment;//付款金额
    private  String payer;//付款人
    private  String payaccount;//付款账号
    private  double rent;//租金
    private double transfee;//运费
    private String rentyear;//租金年份
    private String yundan;//运单号
    private double salarymonth;//人员工资
    public CostManagePO(String date,double payment,String payer,String payaccount,double rent,double transfee, String rentyear,
    		String yundan,double salarymonth){
    	this.date=date;
    	this.payment=payment;
    	this.payer=payer;
    	this.payaccount=payaccount;
    	this.rent=rent;
    	this.transfee=transfee;
    	this.rentyear=rentyear;
    	this.yundan=yundan;
    	this.salarymonth=salarymonth;
    	
    }
      public String getDate(){return date;} 
      public double getPayment(){return payment;}
      public String getPayer(){return payer;}
      public String getPayaccount(){return payaccount;}
      public double getRent(){return rent;}
      public double getSalary(){return transfee;}
      public String getRentyear(){return rentyear;}
      public String getYundan(){return yundan;}
      public double getSalarymonth(){return salarymonth;}
      
}
