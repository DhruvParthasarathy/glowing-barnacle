package mediumProblems;

public class FirstAndLastPositionClean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public int[] searchRange(int[] nums, int target) {
		
		int[] ans = {-1,-1};
		
		ans[0] = binarySearch(nums, target, true);
        
        // search for end only if start has been found
        if(ans[0] != -1) ans[1] = binarySearch(nums, target, false);
		
		return ans;
	}
	
	static int binarySearch(int[] nums, int target, boolean searchStartIndex) {
		
		int ans = -1;
		
		int start = 0; 
		int end = nums.length -1;
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(target < nums[mid]) {
				end = mid -1;
			}
			else if(target > nums[mid]) {
				start = mid + 1;
			}
			else {
				
				// we found a potential answer
				ans = mid;
				
				if(searchStartIndex) {
					// we need to go further left and check
					end = mid -1;
				}
				else {
					// we are looking for end index - we go forward and check in the next array
					start = mid + 1;
				}
			}
			
		}
		return ans;
	}
	

}
