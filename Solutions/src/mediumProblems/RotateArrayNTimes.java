package mediumProblems;

public class RotateArrayNTimes {

	public static void main(String[] args) {
		
		
		int[] arr= {1,2,3,4,5,6,7};
		
		rotate(arr, 3);
		

	}
	
	
    static void rotate(int[] nums, int k) {
        
        // min 1 to 10^5 elements in the array
        // numbers are within range of integers, positive and neg
        // 0 to 10^5 rotations possible
        
        
        int len = nums.length;
        
        // incase after the given number of rotations, we arrive at the same spot then we need not 
        // do the rotation
        
        if(k !=0){
            
            // here we always have a situation where it is wither rotation after reversing 
            // or before reversing the array
            
            // eg: if array length is 5
            // if number of rotation is == 5 then we have reversed the array
            // if num roation is 5 ~ 10 then we have reversed and then started to rotate that
            
            // if num rotation is between 10 - 15, then we are rotating it from the start position
            
            
            // find quotient and remainder

            int q = k/len;
            int rem = k%len;
            

            // reverse the entire array
            reverseArray(nums, 0, len-1);
            
            // flip the first part till the reminder index
            reverseArray(nums, 0, rem-1);
            
            reverseArray(nums, rem, len-1);
        }
        
        // try to maintain in place rotation, with 1 extra space - we can use this to hold the 
        // number which has to be moved to the first spot
        
        // in place sort, is there a way to shift these positions in the array without traversing ?
    }
    
    static void reverseArray(int[] arr, int start, int end){
        
        int s = start;
        
        while(s < end){
            int temp = arr[s];
            arr[s] = arr[end];
            arr[end] = temp;
            s ++;
            end--;
        }
        
    }

}
