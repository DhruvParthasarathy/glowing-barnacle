package easyProblems;

public class ReverseBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverseBits(964176192));

	}
	
	public static int reverseBits(int num) {
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
        
        return num;
	}

//	public static int reverseBits(int n) {
//
//		// we receive a number, whose. bits we need to reverse
//		
//		// we can do it in 2 ways, we can convert it into a string of bits, 
//		
//		// and iteratively swap the bits in that string and convert it back to an integer
//		
//		// or use a string builder and insert back the 
//		
//		// give that we are trying to manipulate bits, let's try using bit manipulation
//		
//		// we know that the given number will have 32 bits, what would we do if we wish to reverse the bits, 
//		
//		// won't we do something like a bit swap ?
//		
//		/*
//		 * Let's try doing a bit swap - what we will be doing here is that
//		 * we will run a while loop and have the first and last index 
//		 */
//		int num = 0;
//		
//		int count = bits -1;
//		
//		/*
//		 *  what we do here is, we keep picking the LSB from the number and shifting it to the
//		 *  start of the bits by adding it to a new number
//		 */
//		int tempNum = 0;
//		while(n > 0) {
//			System.out.println(count);
//			System.out.println(Integer.toBinaryString(n));
//			// check the LSB
//			if( (n & 1)== 1) {
//				// we have a bit to move
//				tempNum = (1 << count);
//				
//			}
//			
//			if(count > (int) (bits-1)/2) {
//				// left shift the temp num and or it with num
//			} else {
//				// right shift temp num and or it with num
//			}
//			
//			count --;
//			
//			n >>= 1; // unsigned right shift
//			
//			System.out.println( Integer.toBinaryString(num));
//			System.out.println();
//		}
//		
//		
//		return num;
//	}
}
