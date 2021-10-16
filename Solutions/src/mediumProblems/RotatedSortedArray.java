package mediumProblems;

public class RotatedSortedArray {

	public static void main(String[] args) {


//		int[] nums = {4,5,6,7,0,1,2};
//		int[] nums = {1};
//		int[] nums = {1,3};
//		int[] nums = {3,5,1};
		int[] nums = {5,1,3};
		
		int target = 0;
//		int target = 3;
//		int target = 1;
		
		
		System.out.println(search(nums, target));

	}
	
	/**
	 * We need to find the index of a target number in a rotated sorted array
	 * 
	 * 
	 * CONSTRAINTS: 1 <= nums.length <= 5000 - there could be just 1 number in the
	 * array !! -104 <= nums[i] <= 104 - negaive numbers also exist in the array
	 * 
	 * All values of nums are unique nums is an ascending array that is possibly
	 * rotated - might not be rotated, hmmm
	 * 
	 * given this rotated array, find the index of a target number in that array
	 */

	/**
	 * If it is not rotated, then it would be an ascending array how do we find if
	 * the array has been rotated or not [0,1,2,4,5,6,7] - before rotation
	 * [4,5,6,7,0,1,2] - after rotation
	 * 
	 * If we are able to find 2 sub arrays, know the array has been rotated
	 * 
	 * Further we also know that initially the array was sorted so if the array has
	 * been rotated, then the first element of the array would always be greater
	 * than the last element
	 * 
	 * also it is guaranteed that the numbers are unique in the array
	 */
	static int search(int[] nums, int target) {

		int ans = -1;
		
		if(nums.length == 1) {
			if(nums[0] == target) {
				return 0;
			}
		}
		else if( nums[0] > nums[nums.length -1]) {
			// has been rotated
			// get the index which is at the split
			
			int index = findPivot(nums);
			
			if(nums[index] == target) {
				return index;
			}
			
			// now we know the index at the split, 
			if(target < nums[0]) {
				ans = binSearch(nums, target, index + 1, nums.length -1);
			}
			else {
				ans = binSearch(nums, target, 0, index);
			}
	
		}
		else {
			// this has not been rotated
			ans = binSearch(nums, target, 0, nums.length -1);
		}
		
		return ans;
		
	}

	static int findPivot(int[] arr) {
		
		// array.length > 1 - min 2 elements
		int index = -1;

		// in this case, the pivot element would be the smallest element
		// [0,1,2,4,5,6,7] rotated at index 3 would give
		// [4,5,6,7,0,1,2]
		// here we notice that because of the rotation, we have 2 sub arrays
		// sorted in ascending order separately
		
		// logic for finding the pivot
		// if for a given index, if the number next to that index is lesser than the given index, 
		// then that index is the split between the 2 sub arrays
		
		// we also have this property that at the point of the split, 
		// the elements to the right would be lesser than the first element
		
		// Eg: [1,2] => [2,1]
		// [0,1,2,4,5,6,7] => [5,6,7,0,1,2,4] 
		
		int s = 0;
		int e = arr.length - 1;
		
		// [2,1]
		
		while(s != e) {
			int m = s + (e - s) /2;
			
			if(arr[m] >= arr[0]) {
				// this could be the index after the split
				index = m;
				// move right
				s = m + 1;
				
			}
			
			else {
				// move left
				e = m;
			}
			
		}
		

		return index;
	}

	static int binSearch(int [] arr, int target, int start, int end) {
		
		// input in ascending order
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				return mid;
			}
			else if(target > arr[mid]) {
				start = mid + 1;
			}
			else {
				end = mid -1;
			}
		}
		
		return -1;
	}
}
