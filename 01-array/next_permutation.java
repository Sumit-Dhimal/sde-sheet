public class next_permutation {

  public static void nextPermutation(int[] nums) {
    int n = nums.length;

    // base cases
    if(n == 1) {
      return;
    }

    if(n == 2) {
      swap(nums, 0, 1);
      return;
    }

    int i = n-2;
    while (i >= 0 && nums[i] >= nums[i+1]) {
      i--;
    }


    if(i >= 0) {
      int j = n-1;

      while(j >= 0 && nums[j] <= nums[i]) {
        j--;
      }

      swap(nums, i, j);
    }

    reverse(nums, i+1);
  }

  public static void reverse(int[] nums, int start) {
    int end = nums.length-1;

    while(start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int arr[] = {1, 2};

    nextPermutation(arr);

    for (int i :  arr) {
      System.out.print(i + " ");
    }
  }
}

/* 
Algorithm:
1. Traverse from the end and find the first index where the current digit is smaller than the next one (this is the "breaking point").
2. Then again traverse from the end to find the first digit greater than the breaking point digit and swap them.
3. Finally, reverse the part of the array to the right of the breaking point to get the smallest next permutation.
4. If no such breaking point exists (entire array is descending), just reverse the whole array.
*/
