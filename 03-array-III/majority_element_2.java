import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majority_element_2 {

  public static List<Integer> majorityElement(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int n = nums.length;
    int miniMajority = n / 3 + 1;

    for (int i = 0; i < n; i++) {
      
      // if key exists return val else return 0
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

      // add to list if equals to n/3
      if (map.get(nums[i]) == miniMajority) {
        list.add(nums[i]);
      }
    }

    return list;
  }
  public static void main(String[] args) {
    int[] nums = {1, 2, 2};

    List<Integer> ans = majorityElement(nums);

    for (Integer e : ans) {
      System.out.println(e);
    }
  }
}
