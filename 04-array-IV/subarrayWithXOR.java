
// Qn: Count subarray with given XOR k

import java.util.HashMap;

/**
 * XOR is calculated as follows:
 * 
 * 0  0 = 0
 * 0  1 = 1
 * 1  0 = 1
 * 1  1 = 0
 * 
 *    0 0 1 
 *    XOR 
 *    0 1 0 
 * =  0 1 1
 * 
 * A XOR B = C
 * A XOR C = B // we will use this to solve  problem
 * 
 * Also prefix XOR and HashMap
 */

public class subarrayWithXOR {
  
  public static long subarrayXor(int arr[], int k) {
    long ans = 0;
    
    HashMap<Integer, Integer> map = new HashMap<>();
    // XOR = 0 exists once before array starts
    map.put(0, 1);
    
    int prefixXOR = 0;
    for (int i = 0; i < arr.length; i++) {
      // A XOR B
      prefixXOR = prefixXOR ^ arr[i];

      // A XOR C
      int required = prefixXOR ^ k;

      // checking if B exists
      if (map.containsKey(required)) {
        ans += map.get(required);
      }

      // store frequency of current prefix XOR
      map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);

    }
    return ans;
  }

  public static void main(String[] args) {
    int arr[] = {4, 2, 2, 6, 4}; 
    int k = 6;

    System.out.println(subarrayXor(arr, k));
  }
}

/**
 * Time complexity: O(N)
 *    We are traversing for n times
 * 
 * Space complexity: O(N)
 *    HashMap can store atmost N elements
 */