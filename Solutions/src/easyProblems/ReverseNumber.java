package easyProblems;

import java.util.Scanner;

public class ReverseNumber {

	/**
	 * Problem Link : https://leetcode.com/problems/reverse-integer/
	 * Given a signed 32-bit integer x, return x with its digits reversed. 
	 * If reversing x causes the value to go outside the signed 32-bit integer range 
	 * [-2^31, 2^31 - 1], then return 0.
	 * 
	 * Assume the environment does not allow you to store 64-bit integers 
	 * (signed or unsigned).
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// given a number / 123 , we need to output 321

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number : ");
		int number = sc.nextInt();
		
		System.out.println(reverseNum(number));
		
		
	}
	
	/**
	 * Edge case : 1534236469
	 * @param x
	 * @return
	 */
	
	static int reverseNum(int x) {
		
		
		// EDGE CASE: we return the same number if the number is single digit
		if(x % 10 == x) return x;
		
		// logic 
		// number % 10 gives the last digit, Eg: 3
		// number /10 gives the number apart from the last number . Eg: 12
		
		// in the next iteration we retain the newNumber value , multiply it by 10 and add the next modulo
		
		/**
		 * Edge case: Input numbers like x = 1534236469
		 * While going through the reversing process, the value of reversedNum at a point will be
		 * 964632435 , where the pending step is to just add 1 to the digit at the unit's place
		 * 
		 * but when we do the step reversedNum*10, the code behaves unexpectedly
		 * giving the value of reversedNum*10 as 1056389758, when we expected 9646324350
		 * 
		 * When checked, the value of 9646324350 is greater than Integer.MAX_VALUE (2147483647)
		 * 
		 * Hence for solving this type of problem, it is better that we stick with a long data type for 
		 * the number rather than using the int data type
		 * 
		 * When we use the long data type we get the expected value of 9646324350 
		 * when we do 964632435*10
		 * 
		 * 
		 */
		long reversedNum = 0;
		
		// we do this till the number is not 0, if so we can return 0
		while(x != 0 ) {
			reversedNum = reversedNum*10 + x%10;
			x /= 10;
		}
		// CASE: We return the a negative number if the give number is negative
		
		
		if(reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) return 0;
		
		// since we are supposed to return an int data type, we change the type back to int
		return (int)reversedNum; // will return 0 if any edge case is met
	}

}
