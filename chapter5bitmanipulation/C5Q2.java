package chapter5bitmanipulation;

public class C5Q2 {
	
	public static void main(String[] args) {
		System.out.println(binToStr(.125));
	}
	
	public static String binToStr(double num) {
		StringBuilder sb = new StringBuilder("0.");
		if(num >= 1 || num <= 0) {
			return "ERROR";
		}
		while(num > 0) {
			num = num * 2;
			if(num >= 1) {
				sb.append(1);
				num = num - 1;
			} else {
				sb.append(0);
			}
		}
		if(sb.length() >=32) {
			return "ERROR";
		}
		return sb.toString();
	}
}