package po;

import java.io.Serializable;

public class DistancePO implements Serializable {
	private static final long serialVersionUID = 1L;
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
