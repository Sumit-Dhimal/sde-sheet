import java.util.ArrayList;
import java.util.List;;

public class reverse_pairs {

  public static void merge(int[] nums, int low, int mid, int high) {
     
    List<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid + 1;

    while (left <= mid && right <= high ) {
      if (nums[left] <= nums[right]) {
        temp.add(nums[left]);
        left++;
      } 
      else {
        temp.add(nums[right]);
        right++;
      }
    }

    // remaining left element
    while (left <= mid) {
      temp.add(nums[left]);
      left++;
    }

    // remaining right element
    while (right <= high) {
      temp.add(nums[right]);
      right++;
    }

    // copying elements to original array
    for (int i = low; i <= high; i++) {
      nums[i] = temp.get(i - low);
    }
  }

  public static int countPairs(int[] nums, int low, int mid, int high) {
    int right = mid + 1;
    int count = 0;

    /**
     * For every element in left sorted array,
     * we will find reverse pairs in right sorted array,
     * if we find an element whihc might not satisfy the condition,
     * we will break the inner loop for that element, cause the array is sorted.
     */
    for (int i = low; i <= mid; i++) {

      // here as 2 * nums[right] cross the limit of int
      // we convert it to long using L as (2L)
      while (right <= high && nums[i] > 2L * nums[right]) {
        right++;
      }

      count += (right - (mid + 1));
    }

    return count;
  }

  public static int mergeSort(int[] nums, int low, int high) {
    int count = 0;
    if (low >= high) return count;
    
    int mid = low + (high - low)/2;

    // divide
    count += mergeSort(nums, low, mid);
    count += mergeSort(nums, mid + 1, high);

    // count reverse pairs
    count += countPairs(nums, low, mid, high);

    // conquer
    merge(nums, low, mid, high);
    
    return count;
  }


  public static int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length-1);
  }

  public static void main(String[] args) {
    int[] nums = {2,4,3,5,1};
    
    System.out.println("Reverse pair count: " + reversePairs(nums));
  }
}


/**
 * Time complexity: O(2N * logN)
 *    countPairs() -> O(N) 
 *      even though we are using nested loop we only move to next larger element in right half array 
 *      and i runs for first half only.
 * 
 *    merge() -> O(N)
 *    mergeSort() -> log(N)
 * 
 * Space complexity: O(N)
 *    We are using an temporary arraylist of n size.
 */