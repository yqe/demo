package po;

import java.io.Serializable;

public class DocumentPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String ID;
	private String time;
	private String statement;
	private String employee;
	private String departureplace;
	private String destination;
	private double price;
	private String yingyetingID;
	private String zhongzhuanID;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getDepartureplace() {
		return departureplace;
	}

	public void setDepartureplace(String departureplace) {
		this.departureplace = departureplace;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getYingyetingID() {
		return yingyetingID;
	}

	public void setYingyetingID(String yingyetingID) {
		this.yingyetingID = yingyetingID;
	}

	public String getZhongzhuanID() {
		return zhongzhuanID;
	}

	public void setZhongzhuanID(String zhongzhuanID) {
		this.zhongzhuanID = zhongzhuanID;
	}

	public DocumentPO(String ID){
		
	}
}