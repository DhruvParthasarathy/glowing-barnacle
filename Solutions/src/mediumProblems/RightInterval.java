package mediumProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RightInterval {

	public static void main(String[] args) {
		
		int[][] intervals = new int[][]{{1,2},{2,3},{0,1},{3,4}};
		
		System.out.println(Arrays.toString(findRightInterval2(intervals)));

	}
	
	public static int[] findRightInterval2(int[][] intervals) {
		
		// optimized solution using binary search
		int[] out = new int[intervals.length];
		
		// Related to Note 1
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		
		// for the integer map, we need to iterate through the array and make a note of 
		// what is the index of each value of the start index of an interval
		
		for(int i = 0 ; i < intervals.length; i++) {
			// we store the information that the start value is at so and so index
			// <startValue, corresponding_index>
			indexMap.put(intervals[i][0], i);
		}
		
		// we sort the array based on the 0th index of each interval 
		// as the 0th index is unique and if sorted, for subsequent elements, we can 
		// omit checking the previous elements
		// because starti < = endi , so when sorted, 
		// there will be no element j before i such that
		// startj >= endi
		
		Arrays.parallelSort(intervals, (int[] t1, int[]t2) -> t1[0] - t2[0]);
		
		
		// we search for the minimum right interval in the array based on the end value of each interval
		
		// we use binary search here
		
		// ======================================
		
		// we will be iterating through the array, and since we have sorted the intervals, we should be able to 
		// restrict the search space to elements after this interval
		// because starti <= endi
		
		// let's take a sorted array of intervals
		// [s1, e1], [s2,e2] .. we know that s1 < s2 and 
		
		// e1 could be > s2 so it is not the next immediate element in the sorted array that will always be the right interval
		
		// and this could be in any position in the unsorted array, 
		// hence we need to know a way to pick the index of that interval from the unsorted array
		
		// Note 1.
		// therefore before we sort the array we, make a note of the start values of each interval 
		// and the index in which they were initially
		
		// THE indexMap (map) has the value of the indices of the start values
		// <startValue, corresponding_index>
		
		// ======================================
		
		
		// let's iterate through the sorted array and trigger a binary search over the remaining elements 
		
		for(int i = 0 ; i < intervals.length; i++) {
			
			// we cannot directly assigned this index as out[i], but it is rather, 
			// out[indexMap.get(intervals[0])] = result from the binary search
			
			// function to do binary search - search space from start index till end of array
			// the same element could be the right interval as well
			
			// find next Right interval
			int nxtSmallStVal = searchRightValue(intervals, i, intervals.length -1);
			
			// once we have the nxtSmallStVal, we need to get it's index from the intial array
			
			// out[index of current start value] = index of nxtSmallStVal
			// binary search alg returns Integer.MIN_VALUE in case we do not have any right interval
			
			int startVal = indexMap.get(intervals[i][0]);
			
			if(nxtSmallStVal == Integer.MIN_VALUE) {
				out[startVal] = -1;
			} else {
				out[startVal] = indexMap.get(nxtSmallStVal);
			}
			
			
		}
		
		return out;
		
	}
	
	public static int searchRightValue(int[][] sortedIntervals, int start, int end) {
		
		int val  = Integer.MIN_VALUE;
		int i = start;
		int currentVal = sortedIntervals[i][1]; // we are comparing the star of the new index, to end of current index
		
		// for this binary search we include both the start and end index in the search
		// start index including the given element
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			// in this binary search we need to find element with start val >= end element of given interval
			// we also need to minimize this 
			
			// TO PROCEEED FROM HERE
			

			int midVal = sortedIntervals[mid][0];
			
			//  if this new interval has start val same as end val of current interval ? 
			
			// can this be the case ? could be 
			
			if(midVal == currentVal) {
				val =  midVal;
				
				// can there be any other interval with the same start value ? Nope, as start values
				// are unique
				break;
				
			} else if (midVal < currentVal) {
				// in this case, we need to move towards the right
				start = mid +1;
			} else {
				// midVal > current val, 
				// this could be the right index
				val = midVal;
				
				// but there could be some other index towards the left where we find an interval with
				// a lower value of start index
				end = mid -1;
			}
			
			
		}
		
		return val;
		
	}
	
	
	
	// Brute force solution down here
    public static int[] findRightInterval1(int[][] intervals) {
      
        
        /* the right interval for a given interval is the one
            that has start value >= end value of given interval
            and this start value is the least
            
            Eg: test cases
            
            [[3,4],[2,3],[1,2]]
            for 3,4 there is no right interval as there is no start value larger than 4 so ans is -1
            
            for 2,3   3,4 is the right interval as this is the closest value to the end of 2,3
            
            for 1,2 the right interval is 2,3 
            
        */
        
        /*
        Constraints: minimum one set is given, max 2 * 10^4 sets
        all intervals have a start and end index
        Values can be -ve or + ve or 0
        
        Each start value is unique 
        */
        
        /*
        We don't see any particular sorting order present, 
        
        the numbers could be shuffled randomly, how do we know where to search ?
        */
        
        /*
        As a brute force, for each entry, we could iterate and find the other entry whose start index is the 
        least possible value that is greater than or equal to this end index
        
        Is this O(n^2) ? 
        
        [[9,1],[8,8],[7,8],[6,1],[5,2],[4,1],[3,1]]
        
        here we see that for 9,1 the least is 3, 1, we have to iterate till the end to find it
        
        */
        
        /*
        EDGE CASES:
        
        single entry in the inerval
        */
        
        if(intervals.length == 1){
            return new int[]{-1};
        }
        
        int[] out = new int[intervals.length];
        
        for(int i = 0; i < out.length; i++){
            out[i] = -1;
        }
        
        for(int i = 0; i < intervals.length ; i++){
            
            // setting default min level
            int[] min = new int[]{-1, 0}; // min index, min value
            boolean set = false;
            
            for(int j = 0;  j < intervals.length; j++){
                
                // we don't want to check the same index as the interval
            	// we can use the same element as the right interval
//                if(i != j){
                    
                    // if the start of second entry is >= end of first entry
                    if(intervals[j][0] >= intervals[i][1]){
                    	
                        
                        // we need to see if this start value is the min start value
                        if(!set){
                            min[0] = j; // we are storing this index to be saved as the answer later
                            min[1] = intervals[j][0]; // we are storign the value of start at this index
                            set = true;
                        }
                        else {
                            // we already have an inerval value set, let's see if this value is lesser than the previous value
                            if(intervals[j][0] < min[1]){
                                // we update the min
                                min[0] = j;
                                min[1] = intervals[j][0];
                                
                            }
                        }
                        
                        
                        
                        
                    }
                    
//                }
            }
            
            // once we have checked all the values in the array, 
            // we update the output array with the min value
            out[i] = min[0];
            
            
            
        }
        
        return out;
        
        
    }	

}
