package po;

public class UserInfoPO {
        private String name;
        private String password;
         
         public UserInfoPO(String n,String p){
        	
        	 name =n;
        	 password=p;
         }

		public String getName() {
			return name;
		}

		public String getPassword() {
			return password;
		}
         
         
}
