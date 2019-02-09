package chapter5bitmanipulation;

public class C5Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -23432;
		int b = 512132;
		System.out.println(numFlips(a, b));
		System.out.println(bitSwapRequired(a, b));
	}
	
	public static int numFlips(int a, int b) {
		
		int flips = 0;
		String firstNum = Integer.toBinaryString(a);
		String secNum = Integer.toBinaryString(b);
		int stringDiff = Math.abs(firstNum.length() - secNum.length());
		
		if(firstNum.length() > secNum.length()) {
			StringBuilder sb = new StringBuilder(secNum);
			for (int i = 0; i < stringDiff; i++) {
				sb.insert(0, "0");
			}
			secNum = sb.toString();
		} else {
			StringBuilder sb = new StringBuilder(firstNum);
			for (int j = 0; j < stringDiff; j++) {
				sb.insert(0, "0");
			}
			firstNum = sb.toString();
		}
		
		for(int k = 0; k < firstNum.length(); k++) {
			if(firstNum.charAt(k) != secNum.charAt(k)) {
				flips++;
			}
		}
		
		return flips;
	}
	
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for(int c = a ^ b; c != 0; c >>>= 1) {
			count += c & 1;
		}
		return count;
	}
	
	// for unsigned integers, can use this method to convert integer to binary representation
	// else simply use Integer.toBinaryString(i) for signed integers
	public static String toBin(int x) {
		
		String val = "";
		StringBuilder sb = new StringBuilder(val);
		while(x > 0) {
			sb.insert(0, x % 2);
			x /= 2;
		}
		
		return sb.toString();
	}
}
