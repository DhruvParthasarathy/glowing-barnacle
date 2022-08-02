package easyProblems;

public class NumberOf1Bits {

	public static void main(String[] args) {
		
		
		System.out.println(Integer.toBinaryString(0x00000003));
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(3&-3);
		System.out.println();
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toBinaryString(-10));
		System.out.println(Integer.toBinaryString(10&-10));
		
		/*
		 * This is called the Hamming weight of the number - the number of 1 bits
		 * 
		 * For finding the number of 1 bits in total , we use the Brian Kernighan's Algorithm
		 * https://iq.opengenus.org/brian-kernighan-algorithm/
		 * 
		 * When we subtract one from any number, it inverts all the bits after the rightmost set bit
		 * Note: The rightmost set bit also gets inverted along with the numbers right to it. 
		 * 
		 * So when we perform n&(n-1), the right most set bit is unset, here we can increment the counter by 1
		 * We continue this till all the bits are unset and the value of the number is 0
		 */

		
	}
	
	public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0 ) {
        	n = n&(n-1);
        	count++;
        }
		return count;
    }
	
	

}
