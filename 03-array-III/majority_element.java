/**
 * Steps:
 * 1. Use hashmap to store element and its count.
 * 2. Use a maxCount element to keep track of highest repeated value.
 * 3. Use ans to store the element with maxCount.
 * 
 */

import java.util.HashMap;

public class majority_element {
  
  public static int majorityElement(int[] nums) {        
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int newVal = map.get(nums[i]) + 1;
        map.put(nums[i], newVal);

        if(maxCount < newVal) {
          maxCount = newVal;
          ans = nums[i];
        }
      }
      else  {
        map.put(nums[i], 1);
        if (maxCount < 1) {
          maxCount = 1;
          ans = nums[i];
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1};

    System.out.println(majorityElement(nums));
  }
}

/**
 * Time complexity: O(N)
 * Space complexity: O(1)
 */