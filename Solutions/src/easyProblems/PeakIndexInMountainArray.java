package easyProblems;

public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {24,69,100,99,79,78,67,36,26,19}; // expect 2
//		int[] nums = {0,10,5,2}; // expect 1
//		int[] nums = {0,2,1,0}; // expect 1
//		int[] nums = {0,1,0}; // expect 1
		
		System.out.printf("Middle index of the input array is: %s",peakIndexInMountainArray2(nums));
		
	}

	/**
	 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
	 * at least 3 elements, => one element will be the peak
	 * numbers are increasing in one direction towards the peak
	 * numbers decrease when moving away from the peak
	 * we need to find this peak index
	 * this peak could be anywhere within the array, not necessarily the middle element
	 * @param arr
	 * @return
	 */
	public static int peakIndexInMountainArray1(int[] arr) {

		int s = 0;
		int e = arr.length - 1;

		// let's begin a binary search
		while (s <= e) {

			int m = s + (e - s) / 2;

			if (m == 0) {
				/** we are at the left end of the array
				 * this will not occur in the first iteration as it is guaranteed that the array
				 * has min3 elements and at least one will be the peak
				 * hence this could happen when we are processing the bin search algo and have
				 * been pushed to the left to search
				 * example test case [3,4,3,2,0]
				 * here the execution would have started with middle element as 3, then saw that
				 * it is part of a decreasing sequence, now as per code, we now check just the
				 * first 2 elements
				 * m is assigned value to 0
				 */
				if (arr[m] < arr[m + 1]) {
					return m + 1;
				}
			}

			// if the elements on either sides of the middle index are lesser than this
			// element
			if (arr[m] > arr[m + 1] && arr[m] > arr[m - 1]) {
				return m;
			}

			// check if it is part of increasing series
			else if (arr[m - 1] < arr[m] && arr[m] < arr[m + 1]) {
				// middle index part of increasing series - the peak will lie in the right of
				// this region
				s = m + 1;
			}

			// part of decreasing series, search left
			else {
				e = m - 1;
			}

		}

		return -1;
	};

	public static int peakIndexInMountainArray2(int[] arr) {

		int s = 0;
		int e = arr.length - 1;
		int ans = -1;
		
		// let's begin a binary search
		// condition for the loop to break is when both start and end point to the same index, 
		// that index would be the peak value
		while (s != e) {

			int m = s + (e - s) / 2;

			// [3,4,3,2,0]
			/**
			 * Rather than checking on both sides of the array
			 * here we just check the elements, middle and middle + 1
			 */
			if(arr[m] > arr[m+1]) { 
				/**
				 * We are in the decreasing part of the array
				 * the answer could be the middle element but it might lie towards the left
				 * so we set the potential answer to be = mid and proceed checking 
				 * in the left along with the mid element
				 * 
				 * here we have no information about mid -1 so while moving towards the left 
				 *  we include mid as well by setting mid as the end index
				 */
				ans = m;
				e = m;
			}
			else {
				/**
				 * element at the middle is smaller than the next element
				 * so we check towards the right
				 * here I know that mid+1 is greater than mid, hence I can directly start checking 
				 * from mid + 1 rather than again checking along with mid and mid + 1
				 */
				s = m + 1;
			}

		}

		return ans;
	};

}
