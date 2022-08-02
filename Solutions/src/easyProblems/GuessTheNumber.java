package easyProblems;

public class GuessTheNumber {

	public static void main(String[] args) {
		
		int n = 10;
		System.out.println(guessNumber(10));

	}
	
	static int guessNumber(int n) {
      
        /*
        We have the range 1 to n
        
        - 1 <= n <= 2^31 -1 ( Integer )
        - Numbers will be picking within the range
        */
        
        /*
        We have to find the number that the user guessed
        */
        int s = 1; int e = n;
        
        while(s <= e){
            
            int m = s + (e-s)/2;
            int correct = guess(m);
            
            if(correct == 0){
                return m;
            }
            else if (correct < 0){
                // target is towards right
                s = m + 1;
            }
            else {
                // target towards left
                e = m -1;
            }
        }
        
        return -1;
    }
	
	static int guess(int num) {
		
		if(num == 6) return 0;
		else if (num <  6) return -1;
		return 1;
	}

}
