package po;

public class VehicleMaintanceInfoPO {
		private String vehicleID;//车辆代号
		private String bussinessID;//营业厅编号
		private String carsID;//车牌号
		private String worktime;//服役时间
		private String driverID;//司机编号
		private String birthday;//出生日期
		private String idendity;//身份证号
		private String mobile;//手机号
		private String sex;//性别
		private String limittime;//行驶证期限
		public VehicleMaintanceInfoPO(String veID,String bussID,String carID,String wt,String driID,String birth,String iden,String mobi,String sex,String ltime){
			this.vehicleID=veID;
			this.bussinessID=bussID;
			this.carsID=carID;
			this.worktime=wt;
			this.driverID=driID;
			this.birthday=birth;
			this.idendity=iden;
			this.mobile=mobi;
			this.sex=sex;
			this.limittime=ltime;
		}
		public String getVehicleID() {
			return vehicleID;
		}
		public String getBussinessID() {
			return bussinessID;
		}
		public String getCarsID() {
			return carsID;
		}
		public String getWorktime() {
			return worktime;
		}
		public String getDriverID() {
			return driverID;
		}
		public String getBirthday() {
			return birthday;
		}
		public String getIdendity() {
			return idendity;
		}
		public String getMobile() {
			return mobile;
		}
		public String getSex() {
			return sex;
		}
		public String getLimittime() {
			return limittime;
		}
		
}
