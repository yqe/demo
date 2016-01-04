package po;

import java.io.Serializable;

//库存盘点的记录
public class StorageCheckPO implements Serializable {
	private static final long serialVersionUID = 1L;

	public String goodsID;
	/* 快递编号 */
	public String time;
	/* 入库时间 */
	public String area;
	/* 区位 */
	public String row;
	/* 排号 */
	public String shelf;
	/* 架号 */
	public String location;
	/* 位号 */
	public String transcenterID;// 中转中新编号
	
	public String destination;

	public StorageCheckPO(String goodno, String time, String area, String row, String shelf, String location,
			String tranID,String destination) {
		// super();

		this.goodsID = goodno;
		this.time = time;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.location = location;
		this.transcenterID = tranID;
		this.destination=destination;
	}

	public String getDestination() {
		return destination;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public String getTranscenterID() {
		return transcenterID;
	}

	public String getGoodno() {
		return goodsID;
	}

	public String getTime() {
		return time;
	}

	public String getArea() {
		return area;
	}

	public String getRow() {
		return row;
	}

	public String getShelf() {
		return shelf;
	}

	public String getLocation() {
		return location;
	}
}
