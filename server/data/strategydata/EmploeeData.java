package strategydata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import employeedataService.EmploeeDataService;
import mysqlimp.MySqlImp;
import po.EmploeePO;
import po.TransPO;

public class EmploeeData implements EmploeeDataService {
	MySqlImp mysqlimp;
	private String position;
	private String name;
	private int salary;
	private String sex;
	private int age;
	private String phonenum;
	private String empID;
	private String id;
	private String address;
	private String area;

	public EmploeePO find(String ID) throws RemoteException {
		try {
			empID = ID;
			mysqlimp = new MySqlImp();
			String find = "SELECT 员工职位,员工姓名,员工薪水,员工性别,员工年龄,员工手机号,员工身份证号,员工家庭住址,地区" + " FROM 员工信息" + " WHERE 员工编号='" + empID
					+ "'";
			ResultSet rs = mysqlimp.query(find);
			rs.next();
			position = rs.getString(1);
			name = rs.getString(2);
			salary = rs.getInt(3);
			sex = rs.getString(4);
			age = rs.getInt(5);
			phonenum = rs.getString(6);
			id = rs.getString(7);
			address = rs.getString(8);
			area=rs.getString(9);
			EmploeePO emppo = new EmploeePO(position, empID, name, salary, sex, age, phonenum, id, address,area);
			// System.out.println(name+age+position+id);
			return emppo;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EmploeeData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Some MySql problem has happened in EmploeeData!");
			return new EmploeePO("不存在", empID, name, salary, sex, age, phonenum, id, address," ");
		}

	}

	public void insertEmp(EmploeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		this.position = po.getPosition();
		this.name = po.getName();
		this.salary = po.getSalary();
		this.sex = po.getSex();
		this.phonenum = po.getPhonenum();
		this.age = po.getAge();
		this.address = po.getAddress();
		this.id = po.getIdendity();
		this.empID = po.getempID();
		this.area=po.getArea();
		try {
			mysqlimp = new MySqlImp();
			String insert = "INSERT INTO 员工信息" + " (员工职位,员工编号,员工姓名,员工薪水,员工性别,员工年龄,员工手机号,员工身份证号,员工家庭住址,地区)" + " VALUES('"
					+ position + "','" + empID + "','" + name + "'," + salary + ",'" + sex + "'," + age + ",'"
					+ phonenum + "','" + id + "','" + address + "','"+area+"')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EmploeeData!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in EmploeeData!");
		}
	}

	public void delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			empID = ID;
			mysqlimp = new MySqlImp();
			String delete = "DELETE FROM 员工信息" + " WHERE 员工编号='" + empID + "'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EmploeeData!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in EmploeeData!");
		}

	}

	public void update(EmploeePO po) throws RemoteException {
		// 这里有点问题回头再改改
		EmploeeData empda = new EmploeeData();
		empda.delete(po.getempID());
		empda.insertEmp(po);
	}

	public ArrayList<EmploeePO> findall() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<EmploeePO> empList = new ArrayList<EmploeePO>();
		try {
			mysqlimp = new MySqlImp();
			String findmore = "SELECT * FROM 员工信息";
			ResultSet rs = mysqlimp.query(findmore);
			while (rs.next()) {
				empList.add(new EmploeePO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10)));
			}
			return empList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EmploeeData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in EmploeeData!");
			return null;
		}

	}

	@Override
	public ArrayList<EmploeePO> findbypos(String position) {
		// TODO Auto-generated method stub

		try {
			ArrayList<EmploeePO> empList = new ArrayList<EmploeePO>();
			mysqlimp = new MySqlImp();
			String findmore = "SELECT * FROM 员工信息"+" WHERE 员工职位='"+position+"'";
			ResultSet rs = mysqlimp.query(findmore);
			while (rs.next()) {
				empList.add(new EmploeePO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10)));
			//System.out.println(rs.getString(2)+rs.getString(3));
			}
			return empList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in EmploeeData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in EmploeeData!");
			return null;
		}
	}

}
