public class merge_sort {

  // function to merge two halves
  public static void merge(int[] nums, int low, int mid, int high) {
    // temporary array
    int[] temp = new int[high - low + 1];

    // starting indices of left and right hlaf
    int left = low;
    int right = mid+1;
    int k = 0;

    // merge elements in order
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp[k++] = nums[left++];
      }
      else {
        temp[k++] = nums[right++];
      }
    }

    // copying remaining elements of left half
    while (left <= mid) {
      temp[k++] = nums[left++];
    }

    // copying remaining elements of right half
    while ( right <= high) {
      temp[k++] = nums[right++];
    }

    // copy back to original array
    for (int i = low; i <= high; i++) {
      // here our original array may start from middle, suppose low = 2, mid = 4, high = 5
      // but our temp array start at 0, and so its size is also small.
      nums[i] = temp[i - low]; 
    }
  }


  public static void mergeSort(int[] nums, int low, int high) {
    // base case
    if (low >= high) return;

    int mid = low + (high - low) / 2;

    // divide
    mergeSort(nums, low, mid);
    mergeSort(nums, mid+1, high);

    // conquer
    merge(nums, low, mid, high);
  }
  
  public static void main(String[] args) {
    
    int[] nums = { 5, 1, 4, 3, 2, };

    mergeSort(nums, 0, nums.length-1);

    for (int i : nums) {
      System.out.print(i);
    }
    System.out.println();
  }
}
