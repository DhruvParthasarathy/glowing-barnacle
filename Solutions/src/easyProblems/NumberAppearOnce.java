package easyProblems;

public class NumberAppearOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 3,3,7,7,10,11,11 };

		System.out.println(singleNonDuplicate(nums));
	}

	public static int singleNumber(int[] nums) {

		/*
		 * non-empty array element appears twice except for one. implement a solution
		 * with a linear runtime complexity and use only constant extra space
		 */

		/*
		 * 1 <= nums.length <= 3 * 10^4 ( minimum 1 number ) negative numbers present
		 */

		/*
		 * Brute force approach would be create a dictionary and increment the counter
		 * for each number and return the key which has value as 1
		 */

		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num ^= nums[i];
		}

		return num;

	}

	public static int singleNonDuplicate(int[] nums) {
		
		int index = -1;
		
		if(nums.length == 1) {
			return nums[0];
		}
		

		/*
		 * Algorithm must run with logN time complexity and constant space complexity
		 */
		
		/*
		 * Sorted array and log n means binary search
		 */
		
		/**
		 * 
		 * Here we just have to identify an element that exhibits a certain property
		 * the number before it and after it are different
		 * 
		 * 1 <= nums.length <= 10^5 : minimum 1 element, max 10^5 elements
		 */
		
		/*
		 * Another way to go about this is that, 
		 * the array will contain odd number of elements if there is only one extra element in it
		 * 
		 * Hence while splitting the array and deciding which half to look at, 
		 * we can decide that based on which half of the array has odd number of elements in it
		 * 
		 * This way we can finally zero on the odd element
		 */
		
		int start = 0, end = nums.length-1;
		int newEnd = 0;
		
		while(start <= end) {
			int mid = start + (end - start )/2;
			
			// now before we split the array, we check if the mid element is the odd one out
			
			// check if we have reached the ends of the array
			
			if((mid == 0 && nums[mid+1] != nums[mid]) ||
					(mid == end && nums[mid-1] != nums[mid]) ||
					(nums[mid+1] != nums[mid] && nums[mid-1] != nums[mid])
					) {
				return nums[mid];
			}

			
			
			//now we know that mid element is not our guy,
			
			// let's see which way to split the array
			if(nums[mid + 1] == nums[mid]) {
				newEnd = mid -1;
			}
			else {
				newEnd = mid;
			}
			
			// check which half of the array has odd elements
			
			if( ((newEnd- start + 1) & 1) == 1 ) {
				// left side is odd
				end = newEnd;
			}
			else {
				// right side is odd
				start = newEnd + 1;
			}
		
		}

		

		return index;
	}
	
	}
