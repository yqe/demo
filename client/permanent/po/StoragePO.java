package po;
public class StoragePO {
	/* 所在城市 */
	public String city;
	/* 快递编号 */
	public String goodNO;
	/* 入库日期，出库日期 */
	public String time;
	/* 目的地 */
	public String destination;
	/* 区位 */
	public String area;
	/* 排号 */
	public int row;
	/* 架号 */
	public int shelf;
	/* 位号 */
	public int location;
	public StoragePO(String city, String goodNO, String time,
			String destination, String area, int row, int shelf, int location) {
		super();
		this.city = city;
		this.goodNO = goodNO;
		this.time = time;
		this.destination = destination;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.location = location;
	}
	public String getCity() {return city;}
	public String getGoodNO() {return goodNO;}
	public String getTime() {return time;}
	public String getDestination() {return destination;}
	public String getArea() {return area;}
	public int getRow() {return row;}
	public int getShelf() {return shelf;}
	public int getLocation() {return location;}
}
