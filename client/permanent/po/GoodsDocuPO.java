package po;

import java.io.Serializable;


/**
 * 快递单
 * @author jjlb
 *
 */
public class GoodsDocuPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String dilivername;
	private String diliveraddress;
	private String diliverworkspace;
	private String dilivermobile;
	private String receivername;
	private String receiveraddress;
	private String receiverworkspace;
	private String receivermobile;
	private double wrappedfee;//包装费
	private double totalfee;//费用合计
	private String expresstype;//快递类型
	private String goodsID;//订单条形码号
	private double weight;//重量
	private String goodsname;//货物名
	private int goodsnumber;//货物数量
	private double length;//长度
	private double width;//宽//
	private double height;//高
	private double v;//体积	
	private String goodsinfo;//货物信息
	private String wrappedtype;//包装种类
	private String expectedtime;//预期到达时间
	private String generatetime;//寄件单生成日期
	private String courier;//快递员姓名

	public double getWeight() {
		return weight;
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


	public String getGoodsname() {
		return goodsname;
	}


	public int getGoodsnumber() {
		return goodsnumber;
	}


	public double getLength() {
		return length;
	}


	public double getWidth() {
		return width;
	}


	public double getHeight() {
		return height;
	}


	public double getV() {
		return v;
	}


	public String getGoodsinfo() {
		return goodsinfo;
	}


	public String getWrappedtype() {
		return wrappedtype;
	}


	public String getExpectedtime() {
		return expectedtime;
	}


	public String getGeneratetime() {
		return generatetime;
	}


	public String getCourier() {
		return courier;
	}


		public GoodsDocuPO(String dname,String daddress,String dworkspace,String dmobile,String rname,String raddress,
				String rworkspace,String rmobile,double wfee,double tfee,String etype,String goodsID,double weight
				,String goodsname,int goodsnum, double len,double wid,double hei,double v,String goodsinfo,String wrappedtype
				,String expectedtime,String generatetime,String name){
			this.dilivername=dname;
			this.diliveraddress=daddress;
			this.diliverworkspace=dworkspace;
			this.dilivermobile=dmobile;
			this.receivername=rname;
			this.receiveraddress=raddress;
			this.receiverworkspace=rworkspace;
			this.receivermobile=rmobile;
			this.wrappedfee=wfee;
			this.totalfee=tfee;
			this.expresstype=etype;
			this.goodsID=goodsID;
			this.weight=weight;
			this.goodsname=goodsname;
			this.goodsnumber=goodsnum;
			this.length=len;
			this.width=wid;
			this.height=hei;
			this.v=v;
			this.goodsinfo=goodsinfo;
			this.wrappedtype=wrappedtype;
			this.expectedtime=expectedtime;
			this.generatetime=generatetime;
			this.courier =name;
			
		}

	
}
