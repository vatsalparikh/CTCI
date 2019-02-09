package chapter5bitmanipulation;

public class C5Q1 {
	
	public static void main(String[] args) {
		System.out.println(insert(~23423, 5, 29, 31));
		System.out.println(updateBits(~23423, 5, 29, 31));
	}
	
	public static int insert(int N, int M, int j, int i) {
		
		int getBit = 0;
		String n = Integer.toBinaryString(N);
		int mask = ~0;
		
		for(int l = j; l <=i; l++) {
			mask = mask ^ (1 << l);
		}
		
		int newN = N & mask;
		System.out.println(newN);
		String m = Integer.toBinaryString(M);
		
		// instead of merging like this merge by simply shifting m by i 
		// and then OR with newN
		for (int k = 0; k < m.length(); k++) {
			
			if ((M & (1 << k)) != 0) {
				getBit = 1;
			} else {
				getBit = 0;
			}
			newN = newN | (getBit << i);
			i++;
		}
		
		return newN;
		
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		// Validation
		if (i > j || i < 0 || j >= 32) {
			return 0;
		}
		
		/* Create a mask to clear bits i through j in n
		/* EXAMPLE: i = 2, j = 4. Result should be 11100011.
		 * (Using 8 bits for this example.  This is obviously not actually 8 bits.)
		 */
		int allOnes = ~0; // allOnes = 11111111
		int left = j < 31 ? (allOnes << (j + 1)) : 0; // 1s until position j, then 0s. left = 11100000	
	  	int right = ((1 << i) - 1); // 1s after position i.  right = 00000011
		int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011
		/* Clear i through j, then put m in there */
		int n_cleared = n & mask; // Clear bits j through i.
		int m_shifted = m << i; // Move m into correct position.
		
		/* OR them, and we're done! */
		return n_cleared | m_shifted; 
	}
}
