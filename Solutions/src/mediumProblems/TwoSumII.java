package mediumProblems;

import java.util.Arrays;

public class TwoSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = {0,0,3,4};
		int target = 0;
		
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

	
	public static int[] twoSum(int[] numbers, int target) {
		
		/*
		 *  1-indexed array of integers
		 *  
		 *  [sorted] in non-decreasing order - ascending, but with duplicates [ 1, 3 , 3, 3, 4], [1,2,2,2,2,2,3,4]
		 *  
		 *  nums = [1,4,7,11,15], target = 15
		 *  
		 *  Find 2 numbers that add to the specific target num
		 *  
		 *  1 <= index1 < index2 <= numbers.length
		 *  
		 *  Only one solution
		 *  
		 *  Cannot use same number twice
		 */
		
		/*
		 * 2 <= numbers.length <= 3 * 104 ( min 2 numbers, till 3 * 10^4 numbers
		 * Numbers are also negative
		 * Target can also be -ve
		 */
		
		/*
		 * Challenge here is to reduce the search space as much as possible
		 * We can use binary search for this
		 */
		
		/*
		 * While returning the response, we need to increment the index by 1
		 */
		
		/*
		 * array = numbers
		 * target
		 */
		
		int i = 0;
		while(i  < numbers.length) {
		
			/* 
			 * we are starting from the first element in the array
			 * to check if any of the other numbers add upto the target value
			 */
			
			/*
			 * Now we are on our quest to find the other element
			 * We need to keep in mind that the other element must not be the same as the current element
			 */
			
			int start = i + 1, end = numbers.length - 1;
			
			while(start <= end) {
				
				// we don't want to include the same number in the result
//				while(numbers[start] == numbers[i]) {
//					i = start;
//					start++;
//				}
				
				
				
//				while(numbers[end] == numbers[i]) {
//					end--;
//				}
				
				int mid = start + (end - start)/2;
				
				if( numbers[i] + numbers[mid] == target) {
					return new int[] {i+1, mid+1};
				}
				
				else if(numbers[i] + numbers[mid] < target) {
					// the mid number is not sufficient to reach the target value
					// we need to search for something towards the right of mid
					
					start = mid + 1;
				}
				else {
					// inculding the target number has overshot the target
					// so we need to include a lesser number
					end = mid -1;
				}
				
			}
			
			

			
			
			i++;

		}
		return new int[] {-1,-1};
        
    }

}
