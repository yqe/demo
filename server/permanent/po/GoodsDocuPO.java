package po;

import mysqlimp.MySqlImp;

public class GoodsDocuPO {
	private String dilivername;
	private String diliveraddress;
	private String diliverworkspace;
	private String diliverhomephone;
	private String dilivermobile;
	private String receivername;
	private String receiveraddress;
	private String receiverworkspace;
	private String receiverhomephone;
	private String receivermobile;
	private double wrappedfee;//包装费
	private double totalfee;//费用合计
	private String expresstype;//快递类型
	private String goodsID;//订单条形码号
	private String receivedtime;//收件日期
	private double receivedmoney;//收款金额
	MySqlImp mysqlimp;
	
		public GoodsDocuPO(String dname,String daddress,String dworkspace,String dhphone,String dmobile,String rname,String raddress,
				String rworkspace,String rhphone,String rmobile,double wfee,double tfee,String etype,String goodsID,String time,double money){
			this.dilivername=dname;
			this.diliveraddress=daddress;
			this.diliverworkspace=dworkspace;
			this.diliverhomephone=dhphone;
			this.dilivermobile=dmobile;
			this.receivername=rname;
			this.receiveraddress=raddress;
			this.receiverworkspace=rworkspace;
			this.receiverhomephone=rhphone;
			this.receivermobile=rmobile;
			this.wrappedfee=wfee;
			this.totalfee=tfee;
			this.expresstype=etype;
			this.goodsID=goodsID;
			this.receivedtime=time;
			this.receivedmoney=money;
		}

		public String getDilivername() {
			return dilivername;
		}

		public String getDiliveraddress() {
			return diliveraddress;
		}

		public String getDiliverworkspace() {
			return diliverworkspace;
		}

		public String getDiliverhomephone() {
			return diliverhomephone;
		}

		public String getDilivermobile() {
			return dilivermobile;
		}

		public String getReceivername() {
			return receivername;
		}

		public String getReceiveraddress() {
			return receiveraddress;
		}

		public String getReceiverworkspace() {
			return receiverworkspace;
		}

		public String getReceiverhomephone() {
			return receiverhomephone;
		}

		public String getReceivermobile() {
			return receivermobile;
		}

		public double getWrappedfee() {
			return wrappedfee;
		}

		public double getTotalfee() {
			return totalfee;
		}

		public String getExpresstype() {
			return expresstype;
		}

		public String getGoodsID() {
			return goodsID;
		}

		public String getReceivedtime() {
			return receivedtime;
		}

		public double getReceivedmoney() {
			return receivedmoney;
		}

		public MySqlImp getMysqlimp() {
			return mysqlimp;
		}
}
