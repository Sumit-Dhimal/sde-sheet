import java.util.Arrays;

/**
 * longestConsecutiveSequence
 */
public class longestConsecutiveSequence {

  public static int longestConsecutive(int[] arr) {
    Arrays.sort(arr);
    
    int count = 1;
    int maxCount = 1;
    
    for (int i = 0; i < arr.length-1; i++) {

      // if next element is consecutive
      if (arr[i+1] - arr[i] == 1) {
        count++;
        maxCount = Math.max(maxCount, count);
        continue;
      }

      // if next element is equal
      if (arr[i+1] == arr[i]) {
        continue;
      }

      // if it is non-consecutive reset count
      count = 1;
    }

    return maxCount;
  }

  public static void main(String[] args) {
    int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

    System.out.println(longestConsecutive(arr));
  }
}

/**
 * Time complexity: O(N)
 *    We are running loop n times
 * 
 * Space complexity: O(1)
 *    We are not using extra space
 */