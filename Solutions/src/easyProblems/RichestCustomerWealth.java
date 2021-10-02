package easyProblems;

public class RichestCustomerWealth {

	/**
	 * https://leetcode.com/problems/richest-customer-wealth/
	 * 
	 * A customer's wealth is the amount of money they have in all their bank accounts. 
	 * The richest customer is the customer that has the maximum wealth.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Input: accounts = [[1,2,3],[3,2,1]] 
	 * Output: 6  // max sum of elements in each sub array
	 * 
	 * accounts = [[1,5],[7,3],[3,5]]
	 * Output: 10
	 * 
	 * accounts = [[2,8,7],[7,1,3],[1,9,5]]
	 * Output: 17// max sum of elements in each sub array
	 * 
	 * CONSTRAINTS:
	 * m == accounts.length
	 * n == accounts[i].length
	 * 1 <= m // min one account person
	 * n <= 50 // maximum 50 accounts per person - could also be 0
	 * 1 <= accounts[i][j] <= 100  // value in each account is from 1 to 100

	 * @param accounts - int[][]
	 * @return
	 */
	static int maximumWealth(int[][] accounts) {
		
		int valueOfMaxCustomer = Integer.MIN_VALUE;
		
		for(int[] customerAccounts : accounts) {
			
			int  valueOfCustomer = 0;
			
			for(int valueInAccount : customerAccounts) {
				valueOfCustomer += valueInAccount;
			}
			
			if(valueOfCustomer > valueOfMaxCustomer) {
				valueOfMaxCustomer = valueOfCustomer;
			}
		}
		
		return valueOfMaxCustomer;
        
    }

}
