package easyProblems;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

	public static void main(String[] args) {
		
		/**
		 * Given an array nums of n integers 
		 * where nums[i] is in the range [1, n], 
		 * return an array of all the integers 
		 * in the range [1, n] that do not appear in nums.
		 */
		
		/**
		 * Numbers start from 1 and there are n integers in the array
		 * 
		 * For example if n is 2, there would be 2 integers in the array
		 * [1,1]. the number 2 is missing here
		 */
		
		/**
		 * n == nums.length - length of the array is the value of n
		 * 1 <= n <= 10^5  - numbers are from 1 till 10^5
		 * 1 <= nums[i] <= n  - every number is less than the length of the array
		 */
		
		/**
		 * As he first step we sort this array using cyclic sort
		 */
		
		int[] nums = {4,3,2,7,8,2,3,1};
		
		cyclicSort(nums);
		
		System.out.println(missingNumbers(nums));

	}

	private static List<Integer> missingNumbers(int[] nums) {
		
		List<Integer> missingNums = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i+1) {
				missingNums.add(i+1);
			}
		}
		return missingNums;
	}

	static void cyclicSort(int[] nums) {
		
		/**
		 *  Here we have numbers from 1 till n 
		 *  were n is the length of the array
		 * 
		 *  Logic for cyclic sort is that
		 *  value = index + 1
		 */
		
		int len = nums.length;
		int i = 0; // keeping track of index
		while(i < len) {
			
			int val = nums[i];
			/** 
			 * if value is within the range of index
			 * Range of index = 0 till len - 1
			 * 
			 * value <= len
			 * 
			 * then we check if it is at the right index
			 * 
			 * also we check if the position to where we swap has the wrong element
			 */
			if(val <= len && val != i + 1 && nums[val-1] != val) {
				/**
				 * this number can be swapped
				 * with the element at it's correct index
				 * 
				 * correct index = value -1
				 */
				
				swap(nums, i, val-1 );
			}
			else { // move ahead
				i++;
			}
		}
		
	}

	static void swap(int[]arr, int i1, int i2) {
		int temp = arr[i2];
		arr[i2] = arr[i1];
		arr[i1] = temp;
	}
}
