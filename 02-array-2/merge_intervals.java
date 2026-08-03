import java.util.ArrayList;
import java.util.Arrays;

public class merge_intervals {
  
  public static int[][] merge(int[][] intervals) {
    
    // sort intervals based on starting point.
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);;

    ArrayList<ArrayList<Integer>> hold = new ArrayList<>();

    int n = intervals.length;
    int i = 0;

    while (i < n) {
      // choose one interval to compare to others
      int start = intervals[i][0];
      int end = intervals[i][1];

      int j = i + 1;
      // check all overlapping intervals
      while(j < n && end >= intervals[j][0]) {
        // extend the end of the current interval [1, 2] [2, 4] => [1, 4]
        end = Math.max(end, intervals[j][1]);
        j++;
      }

      // now add the merged interval to result
      ArrayList<Integer> merged = new ArrayList<>();
      merged.add(start);
      merged.add(end);

      hold.add(merged);

      // move to next non-overlapping intervals
      i = j;
    }

    n = hold.size();
    int m = hold.get(0).size();
    int[][] ans = new int[n][m];

    // copying to ans
    for (i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ans[i][j] = hold.get(i).get(j);
      }
    }
    
    return ans;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

    int[][] res = merge(intervals);

    for (int[] arr : res) {
      for (int val : arr) {
        System.out.print(val + " ");
      }
      System.out.println();
    }
  }
}
