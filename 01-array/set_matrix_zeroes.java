
public class set_matrix_zeroes {

  public static void setZeroes(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int[] markRow = new int[n];
    int[] markCol = new int[m];

    // pass-1: mark row and col that need to zeroed
    for(int i=0; i<n; i++) {
      for(int j=0; j<m; j++) {
        if(matrix[i][j] == 0) {
          markRow[i] = 1;
          markCol[j] = 1;
        }
      }
    }

    // pass-2: set cells to zero based on markers
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(markRow[i] == 1 || markCol[j] == 1) {
                matrix[i][j] = 0;
            }
        }
    }
  }

  public static void main (String[] args) {
    int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

    setZeroes(matrix);

    for (int[] arr : matrix) {
      for(int e: arr) {
        System.out.print(e + " ");
      }
      System.out.println();
    }
  }
}