import java.util.HashSet;

public class find_duplicate_number {

  public static int findDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    // fill the element in hash set and check whether it contains duplicate or not
    for(int i=0; i<nums.length; i++) {
      if(set.contains(nums[i])) {
        return nums[i]; // return duplicate
      } 
      else {
        set.add(nums[i]);
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 2, 2};

     
    System.out.println("The duplicate number is " + findDuplicate(nums));
  }
}