import java.util.ArrayList;
import java.util.List;

public class pascals_triangle {

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    
    for(int i=0; i<numRows; i++) {
      List<Integer> row = new ArrayList<>();

      for(int j=0; j<=i; j++) {
        // fill 1 at last and first element
        if(j == 0 || j == i) {
          row.add(1);
        }
        else {
          int sum = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
          row.add(sum);
        }
      }
      triangle.add(row);
    }

    return triangle;
  }

  public static void main(String[] args) {
    int numRows = 5;

    List<List<Integer>> result = generate(numRows);

    for (List<Integer> list : result) {
      for(int e: list) {
        System.out.print(e + " ");
      }
      System.out.println();
    }
  }
}
