package login;

public class tran {
	
	public static String tran(String str) {
		str = str.replace('年', '-');
		str = str.replace('月', '-');
		str = str.substring(0, str.length()-1);
		return str;
	}
}
