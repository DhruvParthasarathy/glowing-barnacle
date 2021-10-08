package mediumProblems;


public class FirstAndLastPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		int[] numbersAsc = {9,9,9,9,9,9,9,11,13,19,23,29,31};
//		int[] numbersAsc = {0,0,0,0,0,0,0,9,11,13,19,23,29,31};
//		int[] numbersAsc = {9,9,9,9,9,9,9,9,9,9,9,9,9,9};
//		int[] numbersAsc = {0,0,0,0,0,0,0};
		int[] numbersAsc = {2,2};
		
		int target = 1;
		firstAndLast(numbersAsc, target);

	}
	
	

	static void firstAndLast(int[] numbersAsc, int target) {
		
		
		int firstIndex = findFirstIndex(numbersAsc, target);
		int lastIndex = findLastIndex(numbersAsc, target);
		System.out.printf("%s,%s",firstIndex,lastIndex);
		
	}
	
	



	/**
	 * This function is similar to finding the index of the smallest number before the target number
	 * @param numbersAsc
	 * @param target
	 * @return
	 */
	static int findFirstIndex(int[] numbersAsc, int target) {
		
		/**
		 * Logic:
		 * Find the smallest number before this number and return the next index
		 * Edge cases:
		 * When the first number is the given number
		 * When this number does not exist in the array
		 */
		
		if(numbersAsc[0] == target) {
			return 0;
		}
		return binarySearchStartPosition(numbersAsc, target);
	}
	
	/**
	 * This function is similar to finding the index of the smallest number after the target number
	 * @param numbersAsc
	 * @param target
	 * @return
	 */
	static int findLastIndex(int[] numbersAsc, int target) {
		
		/**
		 * Logic:
		 * Find the smallest number after this number and return the previous index
		 * Edge cases:
		 * When the last number is the given number
		 * When this number does not exist in the array
		 */
		
		if(numbersAsc[numbersAsc.length-1] == target) {
			return numbersAsc.length-1;
		}
		return binarySearchEndPosition(numbersAsc, target);
	}


	static int binarySearchEndPosition(int[] numbersAsc, int target) {
		
		int start = 0, end = numbersAsc.length-1;
		
		// condition to stop the while loop
		while(start<=end) {
			
			int middle = start + (end - start)/2;
			
			// move to left array if target is < middle element
			if(target < numbersAsc[middle]) {
				end = middle-1;
			}
			
			// move to right array if target value is >= middle element
			else {
				start = middle+1;
			}
			
		}

		// when he above while loop is violated,  => we have reached the end of possible iterations
		// start will be = end + 1 ( start would be ahead of end )
		// hence to get the index of the number we need start -1
		
		// if the number before the start index is the target we return that 
		if(numbersAsc[start-1] == target) {
			return start-1;
		}
		else {
			return -1;
		}
	}





	private static int binarySearchStartPosition(int[] numbersAsc, int target) {

		int start = 0, end = numbersAsc.length-1;
		
		// condition to stop the while loop
		while(start<=end) {
			int middle = start + (end - start)/2;
			
			// move to right array if target is > middle element
			if(target > numbersAsc[middle]) {
				start = middle+1;
			}
			
			// move to left array if target value is <= middle element
			else {
				end = middle-1;
			}
			
		}

		// when he above while loop is violated, 
		// start will be = end + 1 ( start would be ahead of end )
		// the first position would be at the end + 1 index
		// if there exists an element at that index, and if it is equal to the target, return that index
		if(end != numbersAsc.length-1 && numbersAsc[end+1] == target) {
			return end+1;
		}
		else {
			return -1;
		}
		
	}

}
