package mediumProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[][] matrix = {{1},{0}};
//		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		
		int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
		
		setZeroes(matrix);
		
		System.out.println(Arrays.deepToString(matrix));
		

	}
	
    static void setZeroes(int[][] matrix) {
        
        
        // min one row 
        // max 200 columns
        // columns can be 0
        // values lie within Integer limit
        
        // solution using extra space
        
        // extraSpace(matrix);
        
        // solution using constant space
        constantSpace(matrix);
    }
    
    static void extraSpace(int[][] matrix){
        
        
        // set to keep track of rows
        Set<Integer> rowSet = new HashSet<Integer>();
        
        // set to keep track of columns
        Set<Integer> colSet = new HashSet<Integer>();
        
        for(int i = 0; i < matrix.length; i ++){
            
            for(int j = 0 ; j < matrix[i].length; j ++){
                
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        // now that we have the unique rows and columns that need to be changed ,
        // we can iterate through them and change the values to 0
        
        for(int i = 0; i < matrix.length; i ++){
            
            for(int j = 0 ; j < matrix[i].length; j ++){
                
                if(rowSet.contains(i) || colSet.contains(j)){
                    matrix[i][j] = 0 ;
                    
                }
            }
        }
        

    }

    static void constantSpace(int[][] matrix){
        
        // the idea here is that, if any element is 0, 
        // the entire row and the column has to be made 0,
        // but rather than storing this information in an extra array, we will store this information in the 
        // matrix itself
        
        
        // if any element is 0, then we change the first element in that row to 0
        // and we change the first element in that column to 0 as well
        
        // one edge case arises when we are handling the top row/ first column
        
        // given that we are using the this row and column for storing information about the 
        // remaining cells, we need to store information on whether to 
        // make these 2 arrays 0 or not else where
        
        // to separate this information we will use a variable to store information of the first column
        
        // and we will use the first cell of the top row to store the information about that row
        
        boolean colChange = false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // checking if the first column needs to be changed
        
        for(int row = 0; row < rows; row++){
            
            // if any of the element in the first column is 0, set  the colChange flag to true
            if(matrix[row][0] == 0 ){
                colChange = true;
            }
            
            
            
            // given that we are anyway iterating through each row, let's check the other cells 
            // in the row as well
            
            // if any cell is 0, set the first element in the row to 0, and first elemnt column to 0
            
            // we are inside the for loop iterating over each row
            if(cols > 1) {
                for(int col = 1; col < cols; col++){
                    
                    // iterating over the columns within a row from the first columns, we skip the 0th columns
                    // as we are already checking that in the above function separately
                    
                    if(matrix[row][col] == 0){
                        // set the row start to =
                        matrix[row][0] = 0; 
                        
                        // set the column start to 0
                        matrix[0][col] = 0;
                    }
                    
                }
            }

            
        }
        
        // now we are done with the initial checks, now we need to go ahead and actually convert all the cells to 0s based on the flags we have set
        
        // we do not do this for the first row and the first column right away
        
        for(int row = 1; row <rows; row ++){
            
            for(int col = 1; col <cols; col++){
                
                if(matrix[0][col] == 0 || matrix[row][0] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
        
        
        // now we are left with the first row and the first column
        
        // now check if the first row has to be changed as well
        
        if(matrix[0][0] == 0 ){
            for(int col = 1; col< cols; col++){
                matrix[0][col] = 0;
            }
        }
        
        // we check the row first and then the column because
        // whether the column has to change or not is contained in a separate
        // variable, the row is dependant on the cell in the matrix which would be changed
        // by the column operation if we do that first
        
        // if colChange is true, then we change the entire first column to 0
        if(colChange){
            for(int row = 0; row < rows; row++){
                matrix[row][0] = 0;
            }
        }
        

        
        
        
        
    }

}
