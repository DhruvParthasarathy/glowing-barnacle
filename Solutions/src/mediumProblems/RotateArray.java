class Solution {
    public void rotate(int[] nums, int k) {
        
        // if the number of rotations are above the length of the string
        // we can take the remainer after dividing the num rotations by the length of the string
        // that way we won't have to repeat rotations
        if(k > nums.length){
            k = k%nums.length;
        }
        
        System.out.println("k: " +k);
        
        // given an array , we need to rotate it k times
        // Eg: input array : [1,2,3,4,5,6,7] and k = 3
        // Output must be    [5,6,7,1,2,3,4]
        
        // 
        
        // we can have upto 10^5 elements
        // numbers can be negative 
        
        // can we do it with constant space complexity
        
        int temp = 0;
        
        // shifting elements would time out on larger arrays
        
        // We can try a cyclic aproach where we do a single pass and swap the 
        // elements around
        
        // We are going to solve this using the way we reverse an array
        
        // we first reverse the whole array
        // then we reverse the first part and then we reverse the second part of it
        
        // reverse(0 to last index)
        // reverse(0 to k index)
        // reverse(k+1 to last index)
        
        reverse(nums, 0 , nums.length-1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0 , k-1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, k, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    
    private void reverse(int[] arr, int start, int end){
        
        while(start <= end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start ++;
            end--;
        }

    }
}
