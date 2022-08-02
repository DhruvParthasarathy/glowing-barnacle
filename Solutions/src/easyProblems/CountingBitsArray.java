package easyProblems;

public class CountingBitsArray {

	public static void main(String[] args) {
		
		/**
		 * In this problem, given a number, we need to return an array
		 * which has the number of set bits for all numbers from 0 till the given number
		 * 
		 * We will be using the recurrence relation n(i) = n(i/2) + i%2;
		 * 
		 * Since we will start storing the values of the numbers in an array,
		 * we can access the previous values through the array
		 */

	}
	
	public int[] countBits(int n) {
        
		int[] arr = new int[n+1]; // to include 0th index
		
		arr[0] = 0;
		
		for(int i = 0 ; i<= n; i++) {
			// using recurrence relation
			arr[i] = arr[i>>1] + (i&1);
		}
		
		return arr;
		
    }

}
