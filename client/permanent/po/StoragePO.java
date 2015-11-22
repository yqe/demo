package po;

import java.io.Serializable;

public class StoragePO implements Serializable{
	private static final long serialVersionUID = 1L;
	/* �?在城�? */
	public String city;
	/* 快�?�编�? */
	public String goodno;
	/* 入库日期，出库日�? */
	public String time;
	/* 目的�? */
	public String destination;
	/* 区位 */
	public String area;
	/* 排号 */
	public int row;
	/* 架号 */
	public int shelf;
	/* 位号 */
	public int location;
	public StoragePO(String city, String goodno, String time,
			String destination, String area, int row, int shelf, int location) {
//		super();
		this.city = city;
		this.goodno = goodno;
		this.time = time;
		this.destination = destination;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.location = location;
	}
	public String getCity() {return city;}
	public String getGoodno() {return goodno;}
	public String getTime() {return time;}
	public String getDestination() {return destination;}
	public String getArea() {return area;}
	public int getRow() {return row;}
	public int getShelf() {return shelf;}
	public int getLocation() {return location;}
}
