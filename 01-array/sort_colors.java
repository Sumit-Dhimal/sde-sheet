// Quick sort algorithm is applied

public class sort_colors {

  public static int partition(int[] nums, int low, int high) {
    int pivot = nums[high];
    int i = low - 1;

    for(int j = low; j <= high-1; j++) {
      if(nums[j] < pivot) {
        i++;
        swap(nums, i, j);
      }
    }

    swap(nums, i+1, high);
    return i+1;
  }

  // swap function
  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void quickSort(int[] nums, int low, int high) {
    if(low < high) {
      int partition = partition(nums, low, high);

      quickSort(nums, low, partition-1);
      quickSort(nums, partition+1, high);
    }
  }

  public static void sortColors(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    quickSort(nums, low, high);
  }
  
  public static void main(String[] args) {
    int[] nums = {2,0,2,1,1,0};

    sortColors(nums);

    for( int e: nums) {
      System.out.print(e + " ");
    }
  }
}



