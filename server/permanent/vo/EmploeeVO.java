package vo;

import java.util.ArrayList;

public class EmploeeVO {
	private static final long serialVersionUID = 1L;
	private String ID;//员工ID
	private String name;//员工姓名
	 private int age;//员工年龄
	 private String institution;//员工机构
	private double salary;//员工薪水
	private ArrayList<EmploeeVO> emploee;
	
	 public  EmploeeVO(String ID,String name,int age,String institution,double salary){
		   this.setID(ID);
		   this.setName(name);
		   this.setAge(age);
		   this.setInstitution(institution);
		   this.setSalary(salary);
		    emploee = new ArrayList<EmploeeVO>();
		}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
