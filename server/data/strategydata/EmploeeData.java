package strategydata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import employeedataService.EmploeeDataService;
import mysqlimp.MySqlImp;
import po.EmploeePO;

public class EmploeeData implements EmploeeDataService{
		static MySqlImp mysqlimp;
		private String position;
		private String name;
		private int salary;
		private String sex;
		private int age;
		private String phonenum;
		private String empID;
		private String id;
		private String address;
		
		
		public EmploeePO find(String ID) throws RemoteException {
			try {
				empID = ID;
				mysqlimp=new MySqlImp();
				String find="SELECT 员工职位,员工姓名,员工薪水,员工性别,员工年龄,员工手机号,员工身份证号,员工家庭住址"+" FROM 员工信息"+" WHERE 员工编号='empID'";
				ResultSet rs=mysqlimp.query(find);
				rs.next();
				position=rs.getString(1);
				name=rs.getString(2);
				salary=rs.getInt(3);
				sex=rs.getString(4);
				age=rs.getInt(5);
				phonenum=rs.getString(6);
				id=rs.getString(7);
				address=rs.getString(8);
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			EmploeePO emppo=new EmploeePO(empID,name,age,position,sex,phonenum,salary,id,address);
			return emppo;
		}

		public void insertEmp(EmploeePO po) throws RemoteException {
			// TODO Auto-generated method stub
			this.position=po.getPosition();
			this.name=po.getName();
			this.salary=po.getSalary();
			this.sex=po.getSex();
			this.phonenum=po.getPhonenum();
			this.age=po.getAge();
			this.address=po.getAddress();
			this.id=po.getIdendity();
			this.empID=po.getempID();
		}

		public void delete(String ID) throws RemoteException {
			// TODO Auto-generated method stub
			try {
				empID=ID;
				mysqlimp=new MySqlImp();
				String delete="DELETE FROM 员工信息"+" WHERE 员工编号="+empID;
				mysqlimp.update(delete);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		public void update(String ID, EmploeePO po) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		public void modify(String ID, EmploeePO po) throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		
}
