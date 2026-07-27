
// Kandes's Algorithm or Maximum sub array
public class kadanes_algo {

  public static int maxSubArray(int[] nums) {
    int max = nums[0];
    int currMax = 0;

    for(int i=0; i<nums.length; i++) {
      currMax += nums[i];

      max = Math.max(max, currMax);

      // resetting if the currMax becomes 0
      if(currMax < 0) currMax = 0;
    }
    
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    System.out.println(maxSubArray(nums));
  }
}