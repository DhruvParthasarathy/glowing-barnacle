package easyProblems;

public class SqRootOfNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 808201;
		System.out.println(isPerfectSquare(x));

	}
	
	static int mySqrt(int x) {
        /*
        Constraints
        - x is >= 0;
        - return value must be an integer, truncate decimal parts
        - Not allowed to use sq root operators
        - numbers lies within 0 to 2^31 -1 , integers
        
        */
        
        /*
        We can try solving this with binary search
        Say for example, we have a number 4, we know that the square root of 4 is 2
        Observation 1 - square root is always lesser than the number
        
        Say we have 9, sq root is 3, 3 < 9 3 is also less than 4.5 
        Square roots are always <=  half the number ?
        
        What is the proof for this ?
        
        For 1, root of 1 is 1 ( exception )
        For 2, root of 2 is 1.414.. ( ~1 integer part ~ 2/2 )
        For 3 root is 1.732.. ~ 1 <= 3/2 (1.5)
        For 4, the root is 2 that is <= (4/2)
        For 5, the root is 2.236 , integer part is 2 <= 5/2
        */
        
        /*
        Hence for all numbers > 1 , we can constrict the search space to half of the value of the number
        */
        
        if(x == 0 || x ==1) return x;
        
        int s = 0, e = (int) x /2;
        
        /*
        We find the max number y such that , 
        y * y <= x
        */
        
        int root = 0;
        
        while(s <= e) {
            
            int mid = s + (e-s)/2;
            
            double square = (double)mid*mid;
            
            if(square == x) return mid;
            
            else if ( square < x) {

                s = mid + 1;
            }
            else {
                e = mid -1;
            }
        }
        
        return e;
    }

    public static boolean isPerfectSquare(int num) {
        /*
        We need to write a function that tells if this number is a perfect square or not
        
        We know that the square oot of a given number will lie  between 0 and the number itself
        
        Here our challenge is to minimize the search space to find that number 
        */
        
        /*
        Some sample roots:
        root 2 = 1.414..
        root 4 = 2
        root 9 = 3
        root 16 = 4
        root 25 = 5
        root 36 = 6
        root 100 = 10
        root 10000 = 100
        We see that the search space is very small even as the number increases to a large extent
        We also see that the roots are less than half the number once the number reaches value of 4
        */
        
        if(num == 1){
            return true;
        }
        
        int start = 0, end = num / 2;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if((double)mid*mid == num){
                return true;
            }
            else if ( (double)mid * mid > num){
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return false;
    }
}
