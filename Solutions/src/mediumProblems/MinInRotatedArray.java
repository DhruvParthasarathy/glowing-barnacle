package mediumProblems;

public class MinInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findMin(new int[]{3,4,5,1,2}));

	}
	
    public static int findMin(int[] nums) {
        
        /*
        We have to return the minimum element in the array
        We have minimum 1 element, max 5000 elements
        we also have negative elements
        Unique numbers
        Minimum 1 rotation
        */
        
        /*
        Arr = [1,2,3,4,5,6,7,8]
        Rotated array (4 times) = [5,6,7,8,1,2,3,4]
        Rotated array (1 times) = [8,1,2,3,4,5,6,7]
        Rotated array (7 times) = [2,3,4,5,6,7,8,1]
        The minimum element will be  the element at the index next to the pivot element
        
Pivot element is the element after which the number is lesser
        */
        
        int start = 0, end = nums.length -1;
        int pivotIndex = -1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
            if(mid < nums.length -1 && nums[mid] > nums[mid+1]){
                pivotIndex = mid;
                break;
                // mid is not the pivot
            } else if(nums[mid] < nums[nums.length -1 ]){
               // we are to wards the right of the pivot
                // eg: [5,6,7,8,1,2,3,4] , 1 < 4
                end = mid - 1;
                
            } else {
                // we are towards the left of the pivot
                 // eg: [5,6,7,8,1,2,3,4] , 6 > 4
                start = mid + 1;
            }
        }
        
        return nums[pivotIndex + 1];
        
        
        // retrun pivotIndex;
    }	

}
