import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class fourSum {

  public static List<List<Integer>> findFourSum(int[] nums, int target) {
    int n = nums.length;
    Set<List<Integer>> ans = new HashSet<>();

    // choose first element
    for (int i = 0; i < n; i++) {

      // choose second element
      for (int j = i + 1; j < n; j++) {

        // hashSet to store values between j and k
        HashSet<Integer> seen = new HashSet<>();

        // choose third element
        for (int k = j + 1; k < n; k++) {

          // find fourth number
          long required = (long) target - nums[i] - nums[j] - nums[k];

          // we are checking Integer (MIN and MAx) value to not to calculate if we reach both ends of Integer
          if (
            required >= Integer.MIN_VALUE &&
            required <= Integer.MAX_VALUE &&
            seen.contains((int) required
          )) {
            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) required);

            // sort to maintain unique value
            Collections.sort(temp);
            // only store unique values
            ans.add(temp);
          }

          // new element add to set 
          seen.add(nums[k]);
        }
      }
    }
    
    return new ArrayList<>(ans);
  }

  public static void main(String[] args) {
    int[] nums = {1000000000,1000000000,1000000000,1000000000};
    int target = -294967296;
    List<List<Integer>> ans = findFourSum(nums, target);

    for (List<Integer> arr: ans) {
      for (int e: arr) {
        System.out.print(e + " ");
      }
      System.out.println();
    }
  }
}

/**
 * Time complexity: O(N*N*N) or O(N^3)
 *    We are using three nested loops
 * 
 * Space complexity: O(N + k)
 *    We are using 'ans' to store multiple quadruplets
 *    We are using 'seen' to store single quadruplets
 */
