package po;

import java.io.Serializable;

public class StrategyPO implements Serializable {
	private static final long serialVersionUID = 1L;
		private int  topsal;//总经理月薪
		private int busssal;//营业厅业务员月薪
		private int storagemanagersal;//中转中心仓库管理员月薪
		private int storagesal;//中转中心业务员月薪
		private int financesal;//财务人员月薪
		private int diliversal;//快递员
		private int managersal;//管理员
		private double constance;//价格计算常量
		public StrategyPO(int top,int buss,int stom,int sto,int fina,int dili,int manager,double con) {
			this.topsal=top;
			this.busssal=buss;
			this.storagemanagersal=stom;
			this.storagesal=sto;
			this.financesal=fina;
			this.diliversal=dili;
			this.constance=con;
			this.managersal=manager;
		}
		public int getManagersal() {
			return managersal;
		}
		public int getTopsal() {
			return topsal;
		}
		public int getBusssal() {
			return busssal;
		}
		public int getStoragemanagersal() {
			return storagemanagersal;
		}
		public int getStoragesal() {
			return storagesal;
		}
		public int getFinancesal() {
			return financesal;
		}
		public int getDiliversal() {
			return diliversal;
		}
		public double getConstance() {
			return constance;
		}
}
