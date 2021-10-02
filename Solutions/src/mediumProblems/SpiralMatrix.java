package mediumProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(spiralOrder(matrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		// minimum 1 row
		// maximum number of columns are 10, could be 0 columns

		// values in the matrix range from -100 to 100

		boolean rowIteration = true;
		boolean inOrder = true;

		int numRows = matrix.length; // 3
		int numCols = matrix[0].length; // 3

		int rowStart = 0;
		int colStart = 0;

		int rowEnd = numRows - 1; // 2
		int colEnd = numCols - 1; // 2

		int count = 0;

		List<Integer> ans = new ArrayList<Integer>(numRows * numCols);

		while (count < numRows * numCols) { // count = 3
			// untill we have processed all the elements, we keep the loop alive

			// true // false
			if (inOrder && rowIteration) {

				// along the row in order
				int row = rowStart;

				for (int col = colStart; col <= colEnd; col++) { // 0 to 2

					ans.add(matrix[row][col]);
					count++;

				}

				// count = 3

				// we are done processing this row in an inorder fashion
				// so increment the row start index
				rowStart += 1; // 1

				rowIteration = false;
				inOrder = true;
			}

			else if (inOrder && !rowIteration) {

				// inorder column iteration

				// we need to iterate through the multiple rows of the matrix

				for (int row = rowStart; row <= rowEnd; row++) { // 1 to 2, colEnd == 2

					ans.add(matrix[row][colEnd]);
					count++; // 5
				}

				// we are done processing the column in order
				// decrement the value of column end
				colEnd -= 1;

				// set the order to be out of order row iteration
				rowIteration = true;

				inOrder = false;

			}

			else if (!inOrder && rowIteration) {

				// printing a row in reverse order
				// happens from the bottom right to the bottom left

				for (int col = colEnd; col >= colStart; col--) {

					ans.add(matrix[rowEnd][col]);
					count++;
				}

				rowEnd -= 1;
				rowIteration = false;
				inOrder = false;
			}

			else {
				// out of order column iteration

				// this happens towards the right of the matrix

				// from bottom left to top left

				for (int row = rowEnd; row >= rowStart; row--) {
					ans.add(matrix[row][colStart]);
					count++;
				}

				colStart += 1;
				inOrder = true;
				rowIteration = true;

			}

		}

		return ans;
	}

}
