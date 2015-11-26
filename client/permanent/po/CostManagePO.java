package po;

import java.io.Serializable;
//gfhgfhgfhjf
public class CostManagePO implements Serializable {
	private static final long serialVersionUID = 1L;
    private String date;
    private double payment;
    private  String payer;
    private  long payaccount;
    private  String rent;
    private String salary;
    private String rentyear;
    private String yundan;
    private String salarymonth;
    public CostManagePO(String date,double payment,String payer,long payaccount,String rent,String salary,
    		String yundan,String salarymonth, String rentyear){
    	this.date=date;
    	this.payment=payment;
    	this.payer=payer;
    	this.payaccount=payaccount;
    	this.rent=rent;
    	this.salary=salary;
    	this.rentyear=rentyear;
    	this.yundan=yundan;
    	this.salarymonth=salarymonth;
    	
    }
      public String getDate(){return date;} 
      public double getPayment(){return payment;}
      public String getPayer(){return payer;}
      public long getPayaccount(){return payaccount;}
      public String getRent(){return rent;}
      public String getSalary(){return salary;}
      public String getRentyear(){return rentyear;}
      public String getYundan(){return yundan;}
      public String getSalarymonth(){return salarymonth;}
      
}
