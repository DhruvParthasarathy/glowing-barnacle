package mediumProblems;

import java.util.Arrays;

public class SimilarString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(areSentencesSimilar("aa aa","aa aa A"));

	}
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        if(sentence1.equals(sentence2)) return true;
        
        // we first begin by splitting the sentences in to arrays
        
        String[] sS1 = sentence1.split(" ");
        
        String[] sS2 = sentence2.split(" ");
        
        // System.out.println(Arrays.toString(sS1));
        // System.out.println(Arrays.toString(sS2));
        
        // once we have split the arrays, we can run a loop
        // to check if the words of the sentence match from either ends
        
        // if they do, the middle part can be added to the other sentence
        // and they can be called similar
        
        // each sentence will have minimum one word 
        // so the index can start with 0
        
        // what are the various cases here?
        // the similar words lie at the edges
        // the similar words lie in the middle
        
        int i = -1; // tracking similar words from the beginning
        int j = -1; // tracking similar words from the end
        
        int s = 0; // iterating from the start
        
        int e = 0; // iterating from the end
        
        // we need to start moving from the 0th index and check till the words
        // are common
        
        while(s <= Math.min(sS1.length-1, sS2.length -1) && sS1[s].equals(sS2[s])){
            s++;
            i++;
        }
        
        // similarly we start from the end
        while(e <=  Math.min(sS1.length-1, sS2.length -1) && sS1[sS1.length-1 - e].equals(sS2[sS2.length-1-e])){
            e ++;
            
        }
        

        
        if(e > 0){
            j = e;
        }
        
        // System.out.println(i);
        // System.out.println(j);
        
        // so now we have the start and end sections where the words are similar
        

        // any one string has only one word
        if((sS1.length == 1 || sS2.length == 1) && (i > -1 || j > -1 ) ){
            
            return true;
        }
        
        // if any of of the sentence has just one word then we can go with the above condition,
        
        // if both the sentences have more than 1 word, we need to stick with checking both ends
        // also we need to check if there are no extra letters between both the ends
        // on at least one of the sentence
        
        // there are matches from both sides
        else if(i != -1 && j != -1){
            
            // check if there are no extra words for at least one of the sentence
            // in between both the ends
            
            
            
            // start position = i
            // end position = j
            
            // one string has match and extra words in between
            if(i + 1 == sS1.length -j || i + 1 == sS2.length -j){
                return true;
            }
            
            
        }
        
        // match on any side extends entire length of string 
        else if (s == sS1.length || s == sS2.length ||  e == sS1.length || e == sS2.length){
            return true;
        }
        
        return false;
    }
}
