package mediumProblems;

public class MaxValueAtIndexBoundedArrayBrute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(maxValue(3,2,18));

	}
	
    public static int maxValue(int n, int index, int maxSum) {
        
        int[] nums = new int[n];
        
        // GIVEN CONDITIONS =============================
        
            // nums[i] is a positive int

            // abs(nums[i] - nums[i+1]) <= 1 (we have integers here, so the diff will always be 1 or 0)

            // consecutive numbers can remain the same

            // sum of elements in num <= maxSum

            // nums[i] is maximized
        
        // THOUGHTS ===================================
        
            // what if we keep the first element as the max value, then we cannot fill the remaining elements

            // what if we keep the first Element as 0 ? then we are missing out on the opportunity to maximize it

            // we can thereby start by filling all the elements as the average value of maxSum / n
        
            // now we have the remaining value that can be distributed amongst the elements of the array 

            // but how do we decide which element get's extra value ?

            // it is given that abs(nums[i] - nums[i+1]) <= 1,

            // hence each subsequent elements can be one less , equal or one greater than the current element

            // we could go ahead by adding one to each element untill we reach max sum

            // this way we ensure that no 2 subsequent numbers have a difference greater than 1
        
            // can there be a situation where abs(nums[i] - nums[i+1]) > 1

            // this would only happen when we  add a number greater than 1, to a given element while filling up the values, which we won't be doing
        
        // CATCH
        
            // We could keep adding values to the numbers from the beginning, but the question here is that the value at the given index needs to be maximised
        
            // So it can so happen that we might miss filling the values at the index and fail to maimize it
        
            // hence we need to start filling the values from the given index and spread away from it on both sides to maintian the condition
        
        
        // CONSTRINTS:
        
            // 1 <= length of array <= max sum <= 10^9 this means, minimum one element - edge case

            // index starts from 0
        
        // EDGE CASES:
        
            // there is only one element in the array
        
        if(n == 1){
            
            nums[0] = maxSum;
            
            
            if(index ==  0 ){
                return nums[0];
            } else {
                return Integer.MIN_VALUE;
            }
        }
        
        else {
            
            // array has more than one value
//            fillNumbers(nums,maxSum, index);
        	
        	fillBothSidesMountain(nums, maxSum ,index);
            
            
            
        }
        
        return nums[index];
    
    }
    
    public static void fillNumbers( int[] nums, int maxSum, int index){
        
        
        int avg = maxSum / nums.length;
        
        int sum = 0;
        
        // filling up average value to the array
        for(int i = 0; i < nums.length; i++){
            
            nums[i] = avg;
            sum += avg;
            
        }
        
        // now we have filled the array with the average value
        // if we have some extra values pending to be filled till sum reaches max Value
        
        // int index = 0;
        // while(sum < maxSum){
        //     nums[index] = nums[index]++;
        //     index++;
        //     sum+= 1;
        // }
        
        
        // we cannot fill it in the above mentioned fashion, we need to start at the given index and spread away from it on both sides
        
        // we start with the given index
        
        // till we have reached value of maxSum, we keep filling on both sides of the index

        // In the below approach, we are trying to maintain a flat array, with all the values almost remaining the same
        //        fillBothSidesFlat(nums, maxSum, index, sum);
        
        // but our goal is to maximize the current index
        
//        fillBothSidesMountain(nums, maxSum, index, sum);
        
       
        
        
    }
    
    static void fillBothSidesMountain(int[] nums, int maxSum, int index) {
		
    	
    	// here starting from the given index we will start adding values to the array such that
    	// we add the maximum value to the element at the index, gradually dropping as we reach the sides
    	
    	// in this approach rather than trying to fill all elements by the average, we try to gradually add values 
    	// such that we create a mountain array with the peak at the given index
    	
    	int sum = 0;
    	
        int avg = maxSum / nums.length;
        
        // filling up average value to the array
        for(int i = 0; i < nums.length; i++){
            
            nums[i] = avg;
            sum += avg;
            
        }
    	
    	int count = 1;
    	
    	while(sum < maxSum) {
    		
    		// before filling we need to see if we have sufficient values to maintain the slope on both sides
    		// if not we flatten the tree a bit
    		
    		// check if we have sufficient numbers to maintain mountain array
    		
    		boolean sufficient = ( maxSum - sum ) >= Math.min(nums.length, count);
    		
    		int mountainSide = 1;
    		
    		if(sufficient) {
        		nums[index] = nums[index]+1;
        		sum += 1;
    		}
    		
    		else {
    			mountainSide += maxSum - sum;
    		}

    		
    		int move = count-1;
    		
    		for(int k = mountainSide ; k <= move; k++) {
    			if((index - k) >= 0 && (sum < maxSum)) {
    				nums[index - k] = nums[index-k] +1;
    				sum+=1;
    			}
    			if((index+k) < nums.length && (sum < maxSum)) {
    				nums[index+k] = nums[index+k]+1;
    				sum+=1;
    			}
    			
    		} 
    		
    		count++;
    		
    		
    	}
    	
		
	}

	public static void fillBothSidesFlat(int[] nums, int maxSum, int index, int sum) {
        while(sum < maxSum){
            
            int i = index -1, j = index + 1;
            
            nums[index] = nums[index]+1;
            sum += 1;
            
            // till we reach either ends, fill the left and righ side one by one
            
            while(i >= 0 && j < nums.length && sum < maxSum ){
                nums[i] = nums[i]+1;
                sum++;
                i--;
                
                if(sum >= maxSum) {
                    break;
                }
                
                
                nums[j] = nums[j]+1;
                j++;
            }
            
            // we have hit one of the ends
            while(i >= 0 && sum < maxSum){
                
                nums[i] = nums[i]+1;
                i--;
                sum++;
                
            }
            
            while(j < nums.length && sum < maxSum){
                nums[j] = nums[j]+1;
                j++;
                sum++;
            }
            
            // we have hit both ends
            
            // reset i and j back to the prev value - happens at start of the loop
            
        }
    }

}
