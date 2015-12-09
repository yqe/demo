package po;

/**
 * @author jjlb 货运轨迹
 */
public class ExpressTrailPO {
	private String goodsID;//编号
	private String trail;//货运轨迹

	public ExpressTrailPO(String goodsID, String trail) {
		// TODO Auto-generated constructor stub
		this.trail = trail;
		this.goodsID = goodsID;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public String getTrail() {
		return trail;
	}
}
