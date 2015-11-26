package po;

public class DistancePO {
		private String departurepalce;
		private String destination;
		private double distance;
		public DistancePO(String depar,String desti,double distan){
			this.departurepalce=depar;
			this.destination=desti;
			this.distance=distan;
		}
		public String getDeparturepalce() {
			return departurepalce;
		}
		public String getDestination() {
			return destination;
		}
		public double getDistance() {
			return distance;
		}
}
