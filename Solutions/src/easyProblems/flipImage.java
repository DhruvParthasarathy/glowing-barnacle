package easyProblems;

public class flipImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] flipAndInvertImage(int[][] image) {
		
		/*
		 * Given a 2D array of bits, we need to 
		 * flip the image horizontally, then invert it adn return it
		 * 
		 * Flipping [1,1,0] horizontally results in [0,1,1].
		 * 
		 * Inverting [0,1,1] results in [1,0,0]
		 * 
		 * This is a square matrix
		 * 
		 * 1 <= n <= 20 ( minimum one bit: Eg: [[1]]  or [[0]] )
		 */
		
		if(image.length == 1) {
			// we just have to flip the single bit and return
			image[0][0] ^=  image[0][0];
		} else {
			// we have a 2x2 matrix at least
			/*
			 * [
			 * 	[1,0],
			 * 	[0,1]
			 * ]
			 * 
			 */
			
			// we have to first reverse the array of bits in each row, and then we need to invert the bits
			
			for(int i = 0; i < image.length; i ++) {
				// for each row
				reverseAndInvertArray(image[i]);
			}
		}
		 
		
		return image;
        
    }

	
	public void reverseAndInvertArray(int[] arr) {
		
		int start = 0, end = arr.length -1;
		
		while(start <= end) {
			int temp = arr[end];
			arr[end] = arr[start]^1;
			arr[start] = temp^1;
			start++;
			end--;
		}
		
	}
}
