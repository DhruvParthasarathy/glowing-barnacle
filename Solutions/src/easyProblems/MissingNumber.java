package easyProblems;

public class MissingNumber {

	public static void main(String[] args) {
		
		/**
		 * Given a range of numbers from 0 to n, find the missing number
		 */
		
		int[] arr = {10,9,7,6,5,4,3,2,1,0};
		
		System.out.println(missingNum(arr));

	}

	static int missingNum(int[] arr) {
		
		/**
		 * The numbers are not sorted in any particular order
		 * 
		 * We can use sum of n numbers for this
		 * 
		 * Assume the range is from 0 - 10, we will have 11 numbers
		 * 0,1,... 10, but 1 will be missing so 
		 * 
		 * there will be 10 elements in the array
		 * 
		 * But we only want sum from 1 - 10, that is 10 numbers
		 * 
		 * So n is arr.length (10);
		 */
		
		int n = arr.length;
		int sn = (n*(n+1))/2;
		
		// let's now sum the numbers in the array
		int sum = 0;
		for(int i = 0; i < n ; i++) {
			sum+= arr[i];
		}
		return sn - sum;
	}

}
