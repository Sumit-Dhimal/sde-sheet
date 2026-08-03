import java.util.HashSet;

/**
 * repeating_missing_number2: here we use HashSet approach
 */
public class repeating_missing_number2 {

  public static int[] findMissingAndRepeatedValues(int[][] grid) {
    HashSet<Integer> set = new HashSet<>();
    int n = grid.length;
    int m = grid[0].length;

    int missingValue = -1;
    int repeatedValue = -1;

    // find repeated values
    for (int i=0; i<n; i++) {
      for( int j=0; j<m; j++) {
        if (set.contains(grid[i][j])) {
          repeatedValue = grid[i][j];
        }
        else {
          set.add(grid[i][j]);
        }
      }
    }

    int totalElement = (n * m) + 1;
    // find missing value
    for (int i = 1; i < totalElement; i++) {
      if (!set.contains(i)) {
        missingValue = i;
      }
    }

    return new int[] {repeatedValue, missingValue};
  }

  public static void main(String[] args) {
    int[][] grid = {{1,3}, {2,2}};

    int[] ans = findMissingAndRepeatedValues(grid);
    
    for (int e: ans) {
      System.out.print(e + " ");
    }
  }
}