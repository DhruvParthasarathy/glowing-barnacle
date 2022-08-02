package mediumProblems;

public class CreatePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPalindromeFormation("abdef", "fecab"));
//		StringBuilder sb = new StringBuilder("abc");
//		System.out.println(sb.substring(0,0));
	}
	
    public static boolean checkPalindromeFormation(String a, String b) {
        
        /*
        We need to split both strings at the same index to check if alternate halves results in a palindrome
        
        1 <= a.length, b.length <= 105
        
        The challenge here is to quickly find that index that would result in the alternate halves being equal
        */
        
        /*
        We see that there are some cases here, 
        
        if each string has 1 character, then it is true
        */
        
        if(a.length() == 1 ) {
            return true;
        }
        
        // if any one of the string is a palindrome, return true
        if(isPalin(a) || isPalin(b)){
            return true;
        }
        
        // if the strings have more than 1 character
        // and none of them are palindromes
        
        // we need to build the logic to find that index
        
        // as brute force, let's iterate manually
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        
        for(int i = 0; i < a.length() ; i++){
            
            String suba1 = sa.substring(0, i);
            String suba2 = sa.substring(i);
            
            String subb1 = sb.substring(0, i);
            String subb2 = sb.substring(i);
            
            if(isPalin(suba1 + subb2) || isPalin(subb1+suba2)){
                return true;
            }
            
            
            
            
        }
        
        // no combination worked 
        return false;
        
        
    }
    
    public static boolean isPalin(String a){
        
        StringBuilder sb = new StringBuilder(a);
        String rev = sb.reverse().toString();
        if(rev.equals(a)){
            return true;
        }
        
        return false;
        
    }	

}
