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
				position=rs.getString(1);
				name=rs.getString(3);
				salary=rs.getInt(4);
				sex=rs.getString(5);
				age=rs.getInt(6);
				phonenum=rs.getString(7);
				id=rs.getString(8);
				address=rs.getString(9);
				
				
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

		public void insertEmp(String ID) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		public void delete(String ID, EmploeePO po) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		public void update(String ID, EmploeePO po) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		public void modify(String ID, EmploeePO po) throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		
}
