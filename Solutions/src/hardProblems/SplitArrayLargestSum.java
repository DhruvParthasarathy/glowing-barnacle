package hardProblems;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		
		 int[] nums = {7,2,5,10,8}; int m = 2; // expect 18
//		 int[] nums = {1,2,3,4,5}; int m = 2; // expect 9
//		 int[] nums = {1,4,4}; int m = 3; // expect 4
		System.out.println(findMinMaxSum(nums, m));

	}
	
	static int findMinMaxSum(int[] nums, int m) {
		
		// sum of all elements in the array
		int maxSum = arraySum(nums);
		
		// maximum element in the array
		int minSum = maxValue(nums);
		
		// the range of sums of various sub groups, when split can be within [maxElem, sumElements]
		// maxElem when split into n sub arrays , n == length of the array
		// sumElements when kept as a single array
		
		// we know that we will have split this into 'm' number of sub arrays
				
		while(minSum < maxSum) {
			
			int expectedMax = findExpectedMax(minSum, maxSum); // temp value
			
			// for this expectedMax value, see how many sub arrays are being generated
			
			
			int countSplits  = countSubArrays(expectedMax, nums);

			
			if(countSplits > m) {
				// we have more number of sub arrays, so we can increase the expectedMax
				minSum = expectedMax+1;
			}
			else {
				// let's try getting a lesser expected Max
				maxSum = expectedMax;
			}
		}

		return maxSum;
	}
	
	
	static int findExpectedMax(int start, int end) {
		return start + (end - start)/2;
	}
	
	static int countSubArrays( int max, int[] arr) {
		
		// we have the array
		int count = 0;
		
		int k = 0;
//		int subSumMax = 0;

		// while I have elements
		while(k < arr.length) {

			int subSum = 0;
			// till sum reaches max vaoue, keep adding
			while(k < arr.length && subSum + arr[k] <= max ) {
				subSum += arr[k++];
			}
			
			count++;
			
//			if(subSum > subSumMax) {
//				subSumMax = subSum;
//			}
			
		}
		
		return count;

	}
		
	
	
	static int arraySum(int[] arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i ++) {
			sum  += arr[i];
		}
		return sum;
	}
	
	static int maxValue(int[] arr) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
