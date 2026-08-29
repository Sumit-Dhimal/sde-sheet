import java.util.HashSet;

/**
 *  Longest Substring Without Repeating Characters
 * 
 * Sol: use sliding window concept
 */



public class longestUniqueSubstring {

  public static int lengthOfLongestSubstring(String s) {

    // store unique elements
    HashSet<Character> set = new HashSet<>();

    int left = 0; // left pointer
    int ans = 0; // final ans
    
    for (int right = 0; right < s.length(); right++) {
      int count = 0; // tracks size of every iteration

      // if new or unique element add to set
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
      }

      // if element already exists
      else {
        // remove from left side until it's removed
        while (set.contains(s.charAt(right))) {
          set.remove(s.charAt(left));
          left++;
        }

        // after removing add the current one
        set.add(s.charAt(right));
      }
      
      count = right - left + 1; // size of the current window
      ans = Math.max(ans, count); // choose max size by comparing each iteration
    }

    return ans;
  }

  public static void main(String[] args) {
      String s = "pwwkew";

    System.out.println(lengthOfLongestSubstring(s));
  }
}