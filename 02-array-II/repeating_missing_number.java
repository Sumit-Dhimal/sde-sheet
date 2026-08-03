
/* *
  We have solved it without using collections HashSet
*/

public class repeating_missing_number {

  public static int[] findMissingAndRepeatedValues(int[][] grid) {
    
    int repeatedValue = -1;
    int missingValue = -1;

    // we will treat values of grid as index of dummy variable
    int dummySize = (grid.length * grid[0].length) + 1;
    int[] dummy = new int[dummySize]; // row * col

    // finding repeated value
    for(int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        
        // value to checked
        int val = grid[i][j];

        // if the dummy variable is 0, its new element increase count
        if (dummy[val] == 0) {
          dummy[val] = 1;
        } 
        else {
          repeatedValue = val;
        }
      }
    }

    // finding missing value
    for (int i = 1; i < dummy.length; i++) { // starting with one cause we only have element greater than 0
      if (dummy[i] == 0) {
        missingValue = i;
      }
    }

    int[] ans = {repeatedValue, missingValue};
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,3}, {2,2}};

    int[] ans = findMissingAndRepeatedValues(grid);
    
    for (int e: ans) {
      System.out.print(e + " ");
    }
  }
}