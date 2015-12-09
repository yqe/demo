package login;

public class Tran {
	
	public static String Tran(String str) {
		str = str.replace('年', '-');
		str = str.replace('月', '-');
		str = str.substring(0, str.length()-1);
		return str;
	}
}
