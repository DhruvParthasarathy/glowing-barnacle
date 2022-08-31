package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(letterCombinations("2345"));

	}
	
	public static List<String> letterCombinations(String digits) {
		
		if(digits.isEmpty()) {
			return new ArrayList<String>();
		}
		
		/**
		 * This is like when we try searching for a person's name 
		 * through the keypad of numbers
		 * 
		 * Each number will be linked to a set of letters
		 * 
		 * we will only have digits form 2 to 9
		 */
		
		// let's have the map here
		// we have an array with index 0 - 9, where indices 2 - 9 have letters that
		// will appear on the keypad
		
		String[] letterNumMap = 
				new String[]{
				"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
				};
		
		/**
		 * Example:
		 * Digits: 23
		 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
		 * 
		 * Here we see that we make all possible combinations of one character each from 
		 * the characters mapped to both the numbers
		 * 
		 * If we have more than 2 numbers, the combinations will have those many characters
		 * 
		 * Max 4 digits as we see it
		 * 0 to 4 digits
		 */
		
		/**
		 * So it is basically the number of permutations we can make from 
		 * the set of characters associated with the digits
		 */
		
		/**
		 * This seems like a recursive function that has a processed and an unprocessed part
		 * 
		 * We start by passing in an empty arrayList to carry the output, 
		 * the map and the input number
		 * 
		 * In each call of the recursive loop, we pick one set of letters for processing
		 * Eg: if we have "abc" and "def" we pick "abc" for processing
		 * 
		 * Then we decide if we want to process it with a, or b or c, we have a for loop for this
		 * 
		 * Once we enter the for loop, we append that selected character to the processed string and pass it 
		 * down to the next recursive call
		 * 
		 * Once we reach a point where we don't have any strings left to be processed, we
		 * return the processed string back up and we add it to the list
		 * 
		 */
		
		// Based on the numbers present in the string of digits, let's create an array of letter sets
		
//		ArrayList<String> letterSet = new ArrayList<String>();
		
		String[] letterSet = new String[digits.length()];
		
		for(int i = 0 ; i < digits.length(); i++) {
			letterSet[i] = letterNumMap[ Integer.parseInt( ""+digits.charAt(i) ) ];
//			letterSet.add( letterNumMap[ Integer.parseInt( ""+digits.charAt(i) ) ] );
		}
		List<String> outPut = recursiveProcess("",  new ArrayList<String>(), letterSet );
		
		return outPut;
        
    }	
	
	static ArrayList<String> recursiveProcess(
			String processed, 
			ArrayList<String> outputArray, 
			String[] unProcessed
			){
		
		// once we have depleted all the letter sets that have to be processed, we append the 
		// current word that we have to the output array and send it back
		if(unProcessed.length==0) {
			
			outputArray.add(processed); // this is one possible combination (leaf node)
			return outputArray;
			
		}
		
		String toProcess = unProcessed[0]; // picking the next remaining letter set from the map
		
		for(int i = 0; i < toProcess.length(); i++) {
			
			Character charToProcess = toProcess.charAt(i);
			
			// we pass this off into another recursive loop, to handle the remaining letter sets
			recursiveProcess(processed + charToProcess, outputArray, Arrays.copyOfRange(unProcessed, 1, unProcessed.length));
		}
		
		return outputArray;
	}

}
