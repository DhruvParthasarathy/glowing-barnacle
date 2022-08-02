package easyProblems;

public class SwapCharactersStirng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		System.out.println(restoreString2("codeleet", new int[] {4,5,6,7,0,2,1,3}));
		

	}

	/*
	 * in this problem swapping will not work, because we will be double
	 * swappig a character, once we pass the half of the string
	 * let's try seeing what happens if we only do half the length of the string
	 * still does not work
	 * 
	 *  What we need to actually do is, create a new string by picking and placing letters
	 */
    public static String restoreString(String s, int[] indices) {
        
        /*
        Number of characters in string == num indices
        From, 1 to max 100 characters
        0 indexed array
        No duplicate values in indices array
        */
        
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < indices.length/2; i++){
            // for val at index i, move character at index i to index val
            swap(sb, i, indices[i] );
        }
        
        return sb.toString();
    }
    
    public static void swap(StringBuilder s, int i, int j)
    {
        
        // given 2 indices and a string, swap the characters at those 2 indices
        
        char temp = s.charAt(j);
        s.setCharAt(j, s.charAt(i));
        s.setCharAt(i, temp);
        
        
    }	
	
    public static String restoreString2(String s, int[] indices ) {
    	
    	char[] sb = new char[indices.length];
    	
    	for(int i = 0; i < indices.length; i++) {
    		
    		sb[indices[i]] = s.charAt(i);
    	}
    	
    	
    	
    	
    	return String.valueOf(sb);
    	
    	
    }
}
