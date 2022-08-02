package easyProblems;

public class FindDuplicateNum {

	public static void main(String[] args) {
		
        /*
        We have integers from 1 to n inclusive
        Array contains n + 1 integers 
        
        There is one number that is repeated
        
        There is no guarantee that the other numbers will be present
        
        Return the repeated number, 
        Without modifying the array nums
        and constant extra space
        
        One integer appears two or more times
        
        Eg: [1,3,4,2,2] // n is 4, it has 5 numbers
        Eg: [3,1,3,4,2] // n is 4, we have 5 numbers
        */
        
        /**
         * Solving this with cyclic sort as a brute force approach
         */
		
		int[] nums = {3,4,-1,1};
		
		/**
		 * Since numbers appear from 1 till n, 
		 * value at i is 
		 * value = i + 1
		 */
		
		int i = 0; // tracking index of array
		
		while(i < nums.length) {
			
			// if the number is not in correct index
			// and if the number in target index is not the correct number
			// value must go to value -1 in index
			if(nums[i] >= 0 && nums[i] != i + 1 && nums[nums[i] -1] != nums[i]) {
				
				int temp = nums[nums[i] -1];
				nums[nums[i] -1] = nums[i];
				nums[i] = temp;
					
			}
			else {
				i++;
			}
		}
		
		/**
		 * Now iterate through the array and see which element is not in it's correct spot
		 */
		
		for(int j = 0; j < nums.length; j++) {
			//value at i = i + 1
			if(nums[j] != j+1) {
				System.out.println(nums[j]);
				break;
			}
		}
		
		

	}

}
