
/**
 * Mental Image for the problem
 *  
 * Problem:
 *    0,0   0,1   0,2
 *    1,0   1,1   1,2
 *    2,0   2,1   2,2
 * 
 * 
 * solution: Rotate 90 Degree
 *    2,0   1,0   0,0
 *    2,1   1,1   0,1
 *    2,2   1,2   0,2
 * 
 * Algorithm:
 * 
 * 1. As you can see from above diagram. You can notice on every column the rows are same.
 * 2. So, we will run a outer loop from 0 -> n 
 *    and inner loop from n -> 0
 * 3. We will take inner loop as our row and outer as column.
 * 4. We will give the rotation like feature.
 */

import java.util.ArrayList;

public class rotate_matrix {
  
  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    for(int j = 0; j < n; j++) {
      ArrayList<Integer> temp = new ArrayList<>();
  
      for(int i = n - 1; i >= 0; i--) {
        temp.add(matrix[i][j]);
      }
      ans.add(temp);
    }

    // copy values to original matrix
    for(int i=0; i<n; i++) {
      for(int j=0; j<m; j++) {
        matrix[i][j] = ans.get(i).get(j);
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 7}, {7, 8, 9}};

    rotate(matrix);

    for(int i=0; i<matrix.length; i++) {
      for(int j=0; j<matrix[0].length; j++) {
        System.out.print( matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}

