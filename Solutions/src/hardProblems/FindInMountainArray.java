package hardProblems;

class MountainArray {
	
	int[] arr;
	int len;
	MountainArray(int len) {
		this.len = len;
		
		for(int i = 0 ; i <= len / 2 ; i ++) {
			arr[i] = i;
		}
	}
	
	MountainArray(int[] array) {
        this.arr = array;
	}
	
	public int get(int index) {
		return arr[index];
	}
	
	public int length() {
		return arr.length;
	}
}

public class FindInMountainArray {

	public static void main(String[] args) {
		
		MountainArray arr = new MountainArray(new int[]{0,5,3,1});
		int target = 1;
		
		System.out.printf("Index of the target is: %s ", findInMountainArray(target, arr));
		

	}
	
	
    static int findInMountainArray(int target, MountainArray mountainArr) {
        
        // target = 3
        // [1,2,3,4,5,3,1]
        // minimum 3 elements in  array
        // so here we need to return the minimum index such that mountainArr.get(index) == target.
        
        // here we have 3 at both index 2 and index 5, so we have to return output as 3.
        // in case 3 was not there, we have to return output as 5
        // else return -1
        
        // MountainArray.get(k) returns the element of the array at index k (0-indexed).
        // MountainArray.length() returns the length of the array.
        
        
        // [1,2,3,4,5,3,1]
        int peakIndex = peakIndexInMountainArray(mountainArr); // 4
        
        // if the element at the peak index is the target, then return that
        if(mountainArr.get(peakIndex) == target) {
            return peakIndex;
        }
        
        // [1,2,3,4]
        // would return 2
        int leftIndex = binSearch(mountainArr, target, 0, peakIndex - 1);
        
        if(leftIndex != -1){
            // if the element is present in the left side , that is the answer
            return leftIndex;
        }
        else {
            // return the index of the number in the right side
            // if we have the number on the right, that would be the answer, else 
            // the below function anyways returns -1 if the number is not found
            // [3,1]
            // would return peakIndex + 1 == 5
            return binSearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
        }
        

        
            
    }
    
    
    static int peakIndexInMountainArray(MountainArray arr) {

		int s = 0;
		int e = arr.length() - 1;
		int ans = -1;
		
		while (s != e) {

			int m = s + (e - s) / 2;

			if(arr.get(m) > arr.get(m+1)) { 
				ans = m;
				e = m;
			}
			else {

				s = m + 1;
			}

		}

		return ans;
	};

    static int binSearch(MountainArray mountainArr, int target, int start, int end){
        
        
    	
    	// here we need to to an order agnostic binary search
    	//check for order
    	
    	boolean asc = false;
    	
    	if(mountainArr.get(start) < mountainArr.get(end)) {
    		asc = true;
    	}
    	
        while(start <= end){
            int mid = start + (end - start)/2;
            
            int midElem = mountainArr.get(mid);
            
            if(midElem == target) {
                return mid;
            }
            else if(target < midElem){
            	if(asc) {
            		end = mid - 1;	
            	}
            	else {
            		start = mid + 1;
            	}
                
            }
            else {
            	if(asc) {
            		start = mid + 1;
            	}
            	else {
            		end = mid - 1;
            	}
                
            }
        }
        
        
        return -1;
    }
    

}
