package mediumProblems;

import java.util.Arrays;

public class NumWaysSplitString {

	public static void main(String[] args) {
		
		System.out.println(numWays("100100010100110"));
		
		// [0, 2, 4, 0, 0]

	}
	

    public static int numWays(String s) {
     
        /*
        We have a binary string with 1s and 0s, hence think in terms of bits
        */
        
        /* NOTE - countSetBits function
        We have to split it into 3 such that each sub string has same
        number of set bits - so we will need a way to count number of set bits
        */
        
        /* NOTE
        Also if we have to distribute the 1s equally amongst all the 3, 
        the number of 1s must be a multiple of 3
        */
        
        /*
        We need a function that can get us back the index of these 1s
        */
        int[] onesIndex = new int[s.length()];
        
        int setBitCount = countSetBits(s, '1', 0, s.length(), onesIndex);
        
        if(setBitCount % 3 != 0){
            
            return 0;
            
        }
        
        /*Now we have a string that has number of set bits as a multiple of 3, now what*/
        
        if(setBitCount==s.length()){
            return 1;
        }
        
        if(setBitCount == 0){
            return (s.length()-1)*(s.length()-2)/2;
        }
        
        /*This is more like, the number of ways we can split the string 
        with each sub string having number of bits / 3 number of 1s
        */
        
        int setBitsPerPart = setBitCount / 3;
        
        System.out.println(setBitsPerPart);
        
        // find num of ways in which string can be split such that 
        // each part can have setBitsPerPart number of set bits
        
        /*
        Once we have taken setBitsPerPart number of set bits in the first section, the only variation that can come is how we split the string from that 1 to the next 1 that would be a part of the next set
        */
        

        
        /*Now we know the positions of the indices where ones can be split equally*/
        
        System.out.println(Arrays.toString(onesIndex));
        
        /*Upon closer inspection, we notice that the number  of ways is 
        
        summation of (number of 0s between each of extreme 1s of each segment)*2
        
        */
        
        /*
        Now, we need to find the number of 0s between the first and last ones of each segment, 
        and not the number of characters, this might include ones as well
        */
        
        /*
         * Return (number of characters between last 1 of first segment and first 1 of second segment
         * + num chars between last 1 of second segment and first 1 of last segment ) * 2 
         * */
        
        
        System.out.println(onesIndex[setBitsPerPart] - onesIndex[setBitsPerPart-1]);
        System.out.println(onesIndex[setBitsPerPart*2] - onesIndex[setBitsPerPart*2-1]);
        
        
        return (onesIndex[setBitsPerPart] - onesIndex[setBitsPerPart-1])*(onesIndex[setBitsPerPart*2] - onesIndex[setBitsPerPart*2-1]);

        
    }
    
    public static int countSetBits(String s, char c, int start, int end, int [] arr){
        
        int count = 0;
        
        // StringBuilder sb = new StringBuilder(s);
        
        // we use the 
        for(int i = start ; i < end; i++){
            if(s.charAt(i) == c){
            	arr[count] = i;
                count ++;
                
            }
        }
        
        
        return count;
    }
	

}
