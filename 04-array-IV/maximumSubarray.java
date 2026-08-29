
/*
  Maximum Sum of Distinct Subarrays With Length K
*/

import java.util.*;

public class maximumSubarray {

  public static long maximumSubarraySum(int[] nums, int k) {
    long ans = 0;
    long sum = 0;

    Set<Integer> set = new HashSet<>();

    int left = 0;
    for (int right = 0; right < nums.length; right++) {

      // if duplicate exists, shrink until it is removed
      while (set.contains(nums[right])) {
        set.remove(nums[left]);
        sum -= nums[left];
        left++;
      }

      set.add(nums[right]);
      sum += nums[right];

      // keep window size at most k
      if (right - left + 1 > k) {
        set.remove(nums[left]);
        sum -= nums[left];
        left++;
      }

      // if the size equal to k
      if (right - left + 1 == k) {
        ans = Math.max(ans, sum);
      }
    }
    
     
    return ans;
  }

  public static void main(String[] args) {
    int nums[] = {1,5,4,2,9,9,9};
    int k = 3;

    System.out.println(maximumSubarraySum(nums, k));
  }
}

/**
 * Time complexity: O(N)
 *    It may look like we move O(N*N), but the while loop only moves forward
 * 
 * Space complexity: O(K)
 *    The sliding window size is most k.
 *  
 */
