package chapter5bitmanipulation;

public class C5Q4 {
	
	public static void main(String[] args) {
		
		System.out.println(nextLarger(13948));
		System.out.println(nextSmaller(13967));
	}
	
	public static int nextLarger(int n) {
		
		int num = n;
		int conZeros = 0;
		int conOnes = 0;
		int zeroBitPlace = 0;
		
		while (num > 0 && ((num & 1) == 0)) {
			conZeros++;
			num >>= 1;
		}
		
		while (num > 0 && ((num & 1) == 1)) {
			conOnes++;
			num >>= 1;
		}
		
		if((conZeros + conOnes == 31) | (conZeros + conOnes == 0)) {
			return -1;
		}
		
		zeroBitPlace = conZeros + conOnes;
		
		n |= (1 << zeroBitPlace);
		n &= ~((1 << zeroBitPlace) - 1);
		n |= ((1 << zeroBitPlace) - 1) >> (conZeros + 1);
		
		return n;
	}
	
	public static int nextSmaller(int n) {
		
		int num = n;
		int conOnes = 0;
		int conZeros = 0;
		int oneBitPlace = 0;
		
		while (num > 0 && ((num & 1) == 1)) {
			conOnes++;
			num >>= 1;
		}
		
		while (num > 0 && ((num & 1) == 0)) {
			conZeros++;
			num >>= 1;
		}
		
		if((conZeros + conOnes == 31) | (conZeros + conOnes == 0)) {
			return -1;
		}
		
		oneBitPlace = conOnes + conZeros;
		
		int mask1 = ~0 << (oneBitPlace + 1);
		n &= mask1;
		int mask2 = ((1 << (conOnes + 1)) - 1) << (conZeros - 1);
		n |= mask2;
		
		return n;
	}
}
