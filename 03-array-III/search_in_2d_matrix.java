
/**
 * 
 * search_in_2d_matrix
 * 
 * Notes:
 * 1. We will imagine the 2D array as single 1D array
 * 2. Size of imaginary 1D array is (n * m - 1)
 * 3. row = mid/m;  and col = mid % m;
 *    Example: 
 *    if m = 4; mid = 6;
 *     
 *    we get,
 *    row = 6/4 = 1     col = 6 % 4 = 2
 *    
 * 4. Then we will perform binary search on imaginary array
 */

public class search_in_2d_matrix {


  public static boolean searchMatrix(int[][] matrix, int target) {
    // size of row
    int n = matrix.length;

    // size of col
    int m = matrix[0].length;

    // initial search range for imaginary 1D array
    int low = 0, 
    high = m * n - 1; // 

    // apply binary search
    while (low <= high ) {
      // calculate middle index
      int mid = low + (high - low) / 2;

      // Map 1D indexto 2D co-ordinates
      int row = mid / m;
      int col = mid % m;

      // check if target is found
      if (matrix[row][col] == target) {
        return true;
      }

      // discard left half
      else if (matrix[row][col] < target) {
        low = mid + 1;
      }

      // discard right half
      else {
        high = mid - 1;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
                      { 1, 3, 5, 7},
                      { 10, 11, 16, 20},
                      { 23, 30, 34, 60}};
    
    int target = 34;

    System.out.println("Target found: " + searchMatrix(matrix, target));
  }
}

/*
Time Complexity: O(log(NxM)), where N = given row number, M = given column number.We are applying binary search on the imaginary 1D array of size NxM.

Space Complexity: O(1) as we are not using any extra space.
*/
