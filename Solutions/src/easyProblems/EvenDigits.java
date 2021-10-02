package easyProblems;

public class EvenDigits {

	/**
	 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
	 * constraint that we work under is that 1 <= nums[i] <= 10^5
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] nums  = {12,345,2,6,7896};
		System.out.println(findNumbers3(nums));
	}

	/**
	 * Method to check how many number in a give array are having even number of digits 
	 * - using string conversion
	 * @param nums - integer array
	 * @return
	 */
	static int findNumbers1(int[] nums) {
		int count = 0;
		
		/**
		 * iterate through the array and check if given number has even number of digits or not
		 * we can convert a number to a string and see length of that string 
		 */
		for (int num : nums) {
			String numStr = Integer.toString(num);
			
			if(numStr.length() %2 == 0) {
				count ++;
			}
		}
		return count;

	}

	/**
	 * Longer run time than previous process 
	 */
	static int findNumbers2(int[] nums) {
		int count = 0;
		
		for (int i : nums) {
			if (isEven(i)) {
				count ++;
			}
		}
		
		
		
		return count;
		
	}

	/**
	 * Checking if a number is even by counting it's digits
	 * - dividing by 10
	 * @param i
	 * @return
	 */
	static boolean isEven(int i) {
		int count = 0;
		
		while(i > 0) {
			i /= 10;
			count ++;
		}
		return count %2 == 0;
	}

	
	/**
	 * Count the number of digits of a number using log method
	 * (int) Math.log10(decimalNum) + 1 gives the number of digits of that number
	 * @param nums
	 * @return
	 */
	static int findNumbers3(int[] nums) {
		int count = 0;
		
		for (int i : nums) {
			
			if ( ( (int)Math.log10(i) + 1 ) % 2 == 0) {
				count ++;
			}
		}
		
		
		return count;
	}

}

