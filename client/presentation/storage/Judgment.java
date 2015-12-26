package storage;

public class Judgment {

	public static void main(String[] args) {
		System.out.println(IsInt("16.5"));
		System.out.println(IsDouble("161"));
		System.out.println(IsPercent("75.9%"));
	}
	
	public static boolean IsInt(String str){
		try {
			int num=Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean IsDouble(String str){
		if(IsInt(str))
			return true;
		try {
			double num=Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean IsPercent(String str){
		if(str.charAt(str.length()-1)!='%')
			return false;
		return IsDouble(str.substring(0, str.length()-1));
	} 
}
