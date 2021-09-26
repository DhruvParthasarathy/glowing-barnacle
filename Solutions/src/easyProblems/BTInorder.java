package easyProblems;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(){};
	
	TreeNode( int val ){this.val = val;}
	
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/**
 * LeetCode Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Definition for a binary tree node.
 * 
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 
 */
public class BTInorder {
	

	
	/**
	 * Input: root = [1,null,2,3]
	 * Output: [1,3,2]
	 * 
	 * Input: root = []
	 * Output: []
	 * 
	 * Input: root = [1]
	 * Output: [1]
	 * 
	 * Input: root = [1,2]
	 * Output: [2,1]
	 * 
	 * Input: root = [1,null,2]
	 * Output: [1,2]
	 * 
	 * The number of nodes in the tree is in the range [0, 100].
	 * -100 <= Node.val <= 100
	 * 
	 * Challenge: To use iterative method for solution
	 * 
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        
        return output;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// The inorderTraversal function directly takes in an already created BT
		
		// We do not have a property which mentions that the left node has to be smaller than the root and the right node
		// We construct a tree as we get new data
		
		// A binary tree has the property that the children of the kth index in the array will be the elements in 
		// 2k and 2k + 1th index
		
		String[] input = {"1",null,"2","3"};
		
		// creating a bt from the above given data
		
		TreeNode root = new TreeNode();
		
		

	}

}
