package easyProblems;

public class SortingSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "sentence4 a3 is2 This1";
		System.out.println(sortSentence(str));
	}

    public static String sortSentence(String s) {
        // min 1 words, max 9 words
        
        // brute force
        
        /*
        Split the string based on space
        Create another empty array
        
        Iterate through split words
        Based on the index this word has, populate the other array
        
        Iget back string from other array
        
        */
        
        String[] str = s.split(" ");
        
        String[] newArr = new String[str.length];
        
        for(int i = 0; i < str.length; i++){
            
            int index = Integer.parseInt(str[i].charAt(str[i].length()-1)+"");
            newArr[index] = str[i].substring(0, (str[i].length()-2));
            
        }
        
        return String.join(" ", newArr);
    }	
}
