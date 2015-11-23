package po;

import java.io.Serializable;
import java.util.ArrayList;

public class EmploeePO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String empID;//员工ID
	private String name;//员工姓名
	private int age;//员工年龄
	private String position;//员工职位
	private String sex;
	private String phonenum;
	private double salary;//员工薪水
	private ArrayList<EmploeePO> emploee;
	private String idendity;//身份证
	private String address;//住址
	
	public EmploeePO(String empID,String name,int age,String position,String sex,String phonenum,int salary,String idendity,String address){
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


	public double getSalary() {
		return salary;
	}

	public ArrayList<EmploeePO> getEmploee() {
		return emploee;
	}  
}