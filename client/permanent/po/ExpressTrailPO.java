package po;

import java.io.Serializable;

/**
 * @author jjlb 货运轨迹
 */
public class ExpressTrailPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String depar;//出发地
	private String goodsID;//编号
	private String busstrail;//营业厅货运轨迹
	private String centertrail;//中转中心轨迹
	private String destination;//母的城市
	public ExpressTrailPO(String depar,String goodsID, String busstrail,String center,String des) {
		// TODO Auto-generated constructor stub
		this.depar=depar;
		this.busstrail = busstrail;
		this.goodsID = goodsID;
		this.centertrail=center;
		this.destination=des;
	}

	public String getDepar() {
		return depar;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public String getBusstrail() {
		return busstrail;
	}

	public String getCentertrail() {
		return centertrail;
	}

	public String getDestination() {
		return destination;
	}


}
