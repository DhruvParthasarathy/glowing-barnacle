package easyProblems;

public class NumRowsCoin {

	public static void main(String[] args) {
		
		System.out.println(arrangeCoins(1804289383));

	}

    public static int arrangeCoins(int n) {
        
        /*
        Each complete row i will have  i coins
        While we build the rows, we will keep subtracting a cumulative sum
        number of coins from the remaining coins
        
        */
        
        /*
        Sn = n(n+1)/2
        
        S1 = 1
        S2 = 3
        S3 = 6
        S4 = 10
        S5 = 15
        
        Given n coins, we can only build x number of rows that are full
        such that x <= Si, we need to find this value of i
        
        We need to minimize the search space for i
        
        Apart from i == 1 and i ==2, all for all other values of i, Si > 2*i
        
        
        */
        
        if(n == 1 || n == 2 ){
            return 1;
        }
        
        if ( n == 3){
            return 2;
        }
        
        long start  = 1, end = n/2;
        
        while(start <= end){
            
            long mid = start + (end - start)/2;
            
            long Sn =  mid*(mid+1) / 2 ;
            
            if(Sn == n){
                return (int) mid;
            }
            else if (Sn  > n){
                end = mid -1;
            }
            else {
                start = mid +1;
            }
                
        }
        
        return (int) end;
    }
}
