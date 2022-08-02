package easyProblems;

public class KthMissingNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( findKthPositive(new int[1], 5) );
				
	}
	
    public static int findKthPositive(int[] arr, int k) {
        
        
        // we have an array of positive integers
        
        // strictly increasing order - no duplicates 
        
        // find k'th missing positive integer
        
        // constraints
        
        // array has min 1 elements, max 1000 elements
        
        // values are from 1 till 1000
        
        // k is from 1 till 1000
        
        // array is strictly increasing
        
        // we know that we need to find the missing positive integers
        
        // also since the numbers start from 1, we can say that the number at index i should be i + 1
        
        int len = arr.length;
        
        int i = 0;
        
        int missingCount = 0;
        
        int missingNum = Integer.MIN_VALUE;
        
        int skip = 0;
        
        
        // we start iterating from the 0th index
        
        while(i < len){
            
            
            if(arr[i] == i+1+ skip){
                // we can move on to the next index
                i++;
            } else {
                missingCount ++;
                missingNum = i+1 + skip;
                skip++;
                
                if(missingCount == k){
                    return missingNum;
                }
            }
            
            
        }
        
        // no numbers were missing
        
        // let's see what is the missingCount
        
        int lastNum = arr[len -1];
        
        return lastNum + k - missingCount;
        
        
    }	

}
