
/*
  to mark:  is last element (end / next to mark)
*/

import java.util.Arrays;

public class grid_unique_paths {

  public static int helperFnc(int i, int j, int[][] dp) {
    
    // base case
    if (i == 0 && j == 0) return 1;

    // if we go out of bounds
    if (i < 0 || j < 0) return 0;

    // if already computed, return it
    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    // recursive calls for up and left movement
    int up = helperFnc(i - 1, j, dp);
    int left = helperFnc(i, j - 1, dp);

    // store the result and return
    return dp[i][j] = up + left;
  }

  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int[] row: dp) {
      Arrays.fill(row, -1);
    }

    return helperFnc(m - 1, n - 1, dp);
  }

  public static void main(String[] args) {
    int m = 3, n = 2;

    System.out.println(uniquePaths(m, n));
  }
}

/**
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */