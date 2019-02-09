package chapter5bitmanipulation;

import java.util.ArrayList;

public class C5Q3 {
	
	public static void main(String[] args) {
		System.out.println(flip(49));
		System.out.println(longestSequence(49));
		
	}
	
	public static int flip(int num) {
		
		boolean firstZero = false;
		int length = 0, index = 0, max = 0, start = 0;
		String s = Integer.toBinaryString(num);
		
		while(start < s.length()) {
			
			index = start;
			
			for (int i = index; i < s.length(); i++) {
				
				if(s.charAt(i) == '0' && firstZero == true) {
					if(length > max) {
						max = length; // could do Math.max(length, max)
					}
					firstZero = false;
					length = 0;
					break;
				}
				
				if(s.charAt(i) == '0' && firstZero == false) {
					firstZero = true;
					start = i+1;
				}
				
				length++;
				
				if(i == s.length() - 1) {
					start = s.length();
					if(length > max) {
						max = length;// could write Math.max(length, max)
					}
				}
			}
		}
		
		return max;
	}
	
	public static int longestSequence(int n) {
		if (n == -1) return Integer.BYTES * 8;
		ArrayList<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
		}

	public static ArrayList<Integer> getAlternatingSequences(int n) {
		 ArrayList<Integer> sequences = new ArrayList<Integer>();

		 int searchingFor = 0;
		 int counter = 0;

		 for (int i = 0; i < Integer.BYTES * 8; i++) {
		 if ((n & 1) != searchingFor) {
		 sequences.add(counter);
		 searchingFor = n & 1;
		counter = 0;
		 }
		 counter++;
		 n >>>= 1;
		 }
		 sequences.add(counter);

		 return sequences;
		 } 
	
	public static int findLongestSequence(ArrayList<Integer> seq) {
		 int maxSeq = 1;

		 for (int i = 0; i < seq.size(); i += 2) {
		 int zerosSeq = seq.get(i);
		 int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
		 int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;

		 int thisSeq = 0;
		 if (zerosSeq == 1) { 
		 thisSeq = onesSeqLeft + 1 + onesSeqRight;
		 } if (zerosSeq > 1) { 
		 thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft);
		 } else if (zerosSeq == 0) { 
		 thisSeq = Math.max(onesSeqRight, onesSeqLeft);
		 }
		 maxSeq = Math.max(thisSeq, maxSeq);
		 }
		
		 return maxSeq;
		 }
	
}
