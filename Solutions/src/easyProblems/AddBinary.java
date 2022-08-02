package easyProblems;

import java.math.BigInteger;

public class AddBinary {
	
	public static void main(String[] args) {
		
		
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		
		System.out.println(addBinary(a,b));
		
	}
	
	
    static String addBinary(String a, String b) {
    	
    	// we have 2 binary strings, that we need to convert to numbers and add it
    	
    	// we need to convert it from binary to decimal before we proceed
    	

    	
    	
    	
//    	String sum = convertToBase10(a) + convertToBase10(b);
    	
    	/**
    	 * In this approach we are trying to use the int data type to store the value of this number
    	 * as an intermediate step
    	 * 
    	 * But given that then number of bits can go up to 10000, it is not possible to store it 
    	 * using int or long data type
    	 * 
    	 * Hence we need to manually execute bit wise addition and return the response string
    	 */


    	StringBuilder sb = new StringBuilder("");
    	
    	/* we we perform the addition operation, we insert the result of the addition operation
    	 * in this string builder
    	 */
    	
    	/*
    	 * How do we do this addition, we take both the numbers and start comparing the index from the 
    	 * LSB to the Most Significant Bit
    	 * 
    	 * Incase both bits are 1, we have a carry of 1, and the value is 0
    	 * 
    	 * We need to keep in mind that one number can have lesser number of digits
    	 * than the other number
    	 */
    	
    	int indexA = a.length() - 1, indexB = b.length() - 1;
    	
    	int carry = 0;
    	/* We have a for loop that performs the calculation for each step
    	 */
    	
    	/*
    	 * Assume a has 3 bits and b has 5 bits
    	 * 
    	 * a =     1 1 1
    	 * b = 1 0 1 1 0
    	 * 
    	 * We will have to continue adding till we perform x number of operations as there are in 
    	 * the number with lesser number of bits
    	 */
    	
    	int maxIndex = Math.max(indexA, indexB);
    	
    	int numA, numB;
    	for(int i = maxIndex ;i >= 0; i--) {
    		
    		/*
    		 * We start the iteration from the end of the string, till we reach
    		 * the start of the string 
    		 */
    		
    		  if(indexA >= 0 ) {
    			  numA = Integer.parseInt(a.charAt(indexA) + "");
    			  indexA --;
    		  } else {
    			  numA = 0;
    		  }
    		  
    		  if(indexB >= 0) {
    			  numB = Integer.parseInt(b.charAt(indexB)+ "");
    			  indexB --;
    		  } else {
    			  numB = 0;
    		  }
    		  
    		  // now we have both the numbers that we need to add
    		  if(carry + numA + numB == 3) {
    			  carry = 1;
    			  sb.insert(0, 1);
    		  }
    		  else if(carry + numA + numB == 2) { // 1, 1
    			  carry = 1;
    			  sb.insert(0, 0);
    		  } else if (carry + numA + numB == 1) { // 1 0 / 0 1
    			  carry = 0;
    			  sb.insert(0, 1);
    		  } else { // 0 0 
    			  carry = 0;
    			  sb.insert(0, 0);
    		  }
    		  
    	}
    	
    	if(carry == 1) {
    		sb.insert(0, 1);
    	}
    	
		return sb.toString();
        
    }
    
    static String convertToBase10(String num) {
    	
    	// 1 <= a.length, b.length <= 10^4
    	
    	/*
    	 *  since the number of digits could go up till 10^4, it would be unwise to store the value
    	 *  of this number using the int data type, hence we resort to string iteration to obtain the
    	 *  decimal value of this number
    	 */
    	
    	/**
    	 * In this approach we are trying to use the int data type to store the value of this number
    	 * as an intermediate step
    	 * 
    	 * But given that then number of bits can go up to 10000, it is not possible to store it 
    	 * using int or long data type
    	 * 
    	 * Hence we need to manually execute bit wise addition and return the response string
    	 */
    	

    	StringBuilder sb = new StringBuilder("");
    	
    	// we we perform the addition operation, we insert the result of the addition operation
    	// in this string builder
    	
    	return "";
    }
}