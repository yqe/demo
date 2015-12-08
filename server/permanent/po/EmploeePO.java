package po;

import java.io.Serializable;
import java.util.ArrayList;

public class EmploeePO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String area;//地区
	private String empID;//员工ID
	private String name;//员工姓名
	private int age;//员工年龄
	private String position;//员工职位
	private String sex;
	private String phonenum;
	private int salary;//员工薪水
	private ArrayList<EmploeePO> emploee;
	private String idendity;//身份证
	private String address;//住址
	
	public EmploeePO(String position,String empID,String name,int salary,String sex,int age,String phonenum,String idendity,String address,String area){
		this.area=area;
		this.empID=empID;
		this.name=name;
		this.age=age;
		this.position=position;
		this.sex=sex;
		this.phonenum=phonenum;
		this.salary=salary;
		this.idendity=idendity;
		this.address=address;
	}
	
	public String getempID(){
		return empID;
	}
	
    public String getPosition() {
		return position;
	}

	public String getSex() {
		return sex;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public String getIdendity() {
		return idendity;
	}


	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


	public int getSalary() {
		return salary;
	}

	public ArrayList<EmploeePO> getEmploee() {
		return emploee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getArea() {
		return area;
	}

	public String getEmpID() {
		return empID;
	}



 
}