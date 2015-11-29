package po;

public class InputStorageDocuPO {
		private String goodsID;
		private String intime;
		private String destination;
		private String area;//区号
		private String queue;//排号
		private String shelf;//架号
		private String local;//位号
		private String transcenterID;//中转中心编号
		public InputStorageDocuPO(String goodsID,String intime,String desti,String area,String queue,String shelf,String local,String transID){
			this.goodsID=goodsID;
			this.intime=intime;
			this.destination=desti;
			this.area=area;
			this.queue=queue;
			this.shelf=shelf;
			this.local=local;
			this.transcenterID=transID;
		}
		public String getTranscenterID() {
			return transcenterID;
		}
		public String getGoodsID() {
			return goodsID;
		}
		public String getIntime() {
			return intime;
		}
		public String getDestination() {
			return destination;
		}
		public String getArea() {
			return area;
		}
		public String getQueue() {
			return queue;
		}
		public String getShelf() {
			return shelf;
		}
		public String getLocal() {
			return local;
		}
}
