package po;

import java.io.Serializable;

public class StrategyPO implements Serializable {
	private static final long serialVersionUID = 1L;
		private String position;//职位
		private int salary;//对应职位薪水
		private int constant;//价格计算公式常量
		public StrategyPO(String pos,int sal,int cons){
			this.position=pos;
			this.salary=sal;
			this.constant=cons;
		}
		public String getPosition() {
			return position;
		}
		public int getSalary() {
			return salary;
		}
		public int getConstant() {
			return constant;
		}
		
}
