import java.util.Arrays;

public class merge_sorted_arrays {

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    // check in which array to merge
    int size_1 = nums1.length;
    int size_2 = nums2.length;

    // base case
    if (size_1 == size_2) return;

    // merge in nums1
    if (size_1 > size_2) {
      int i = m;
      int j = 0;
      while (i < size_1 && j < n) {
        nums1[i] = nums2[j];
        i++;
        j++;
      }
      Arrays.sort(nums1);
    } else { // merge in nums2
      int i = n;
      int j = 0;
      while (i < size_2 && j < m) {
        nums2[i] = nums1[j];
        i++;
        j++;
      }
      Arrays.sort(nums2);
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = {2, 5, 6};
    int n = 3;

    merge(nums1, m, nums2, n);

    System.out.print(" nums1: ");
    for (int e : nums1) {
      System.out.print(e + " ");
    }
    System.out.println();


    System.out.print("nums2: ");
    for (int e : nums2) {
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
