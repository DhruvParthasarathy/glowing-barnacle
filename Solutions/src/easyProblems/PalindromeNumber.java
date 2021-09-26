package easyProblems;

import java.util.Scanner;

public class PalindromeNumber {

	/**
	 * Problem Link: https://leetcode.com/problems/palindrome-number/
	 * 
	 * Given an integer x, return true if x is palindrome integer.
	 * An integer is a palindrome when it reads the same backward as forward. 
	 * For example, 121 is palindrome while 123 is not.
	 * 
	 * CASE: Positive number will same digits on either side 
	 * Input: x = 121
	 * Output: true
	 * 
	 * CASE: Negative numbers should return false
	 * Input: x = -121
	 * Output: false (From left to right, it reads -121. From right to left, it becomes 121-. )
	 * 
	 * CASE: Positive number with different digits on either side
	 * Input: x = 10
	 * Output: false
	 * 
	 * CONSTRAINT
	 * -231 <= x <= 231 - 1
	 * 
	 * CHALLENGE: Solve without converting the integer to string
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number to test : ");
		int x = sc.nextInt();
		
		System.out.println(isPalindrome(x));
		
		sc.close();
		
		
	}
	
	static boolean isPalindrome(int x) {
		
		//Negative numbers should return false
		if(x  < 0) return false;
		
		// Positive numbers - find the reversed number
		
		if(x % 10 == x) return true;  // if it is a single digit +ve number
		
		long reversedNum = 0;
		
		int temp = x;
		
		// Reversing the number to check if it is a palindrome 
		// Logic for reversing a number present in ReverseNumber problem file
		// https://github.com/DhruvParthasarathy/glowing-barnacle/blob/main/Solutions/src/easyProblems/ReverseNumber.java
		while(temp != 0 ) {
			reversedNum = reversedNum*10 + temp%10;
			temp /= 10;
		}
		
		if((int)reversedNum == x) return true;
		
		return false;
	}
	

}
