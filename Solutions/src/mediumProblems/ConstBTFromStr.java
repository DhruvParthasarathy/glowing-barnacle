package mediumProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given a string input as an array how do you construct a binary tree ?
 * @author dhruv
 *
 */
public class ConstBTFromStr {
	
	/**
	 * For a given sub tree and it's level from the root, we can add the elements to the bst in a recursive
	 * fashion
	 * @param x
	 * @param elements
	 * @param levelFromRoot
	 * @return
	 */
	public static TreeNode construct(TreeNode x, List<String> elements, int levelFromRoot){
		
		/**
		 * Need to figure out this logic and then code
		 */
		return x;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the list of elements as comma separated variables :");
		String input  = sc.nextLine();
		
		/**
		 *  these elements will have spaces attached to them as we are directly taking info from the cli
		 *  Example outputs: 
		 *  [1,  22,      3,     44,     55]
		 *  [1,  null,  2,  3]
		 *  [1, 2, 3, 4]
		 */
		// For iteration, we need the first element to be null as we start from 1
		List<String> elementsList = Arrays.asList(input.split(","));
		
		
		/**
		 * We know that in a BT, the child elements of the kth element 
		 * in an array would be the 2k + 1  and 2k + 2th elements
		 */
		TreeNode root = null;
		
		root = construct(root, elementsList, 0);
		
		sc.close();
	}

}

class TreeNode{
	TreeNode left, right;
	String val;
	
	TreeNode(){};
	
	TreeNode(String val){
		this.val = val;
	}
	
}
