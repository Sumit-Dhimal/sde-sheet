/*
    Applying merge sort for optimal approach
*/

public class inversion_of_array {
  
  public static int merge(int[] arr, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];

    // starting index for left and right half
    int left = low;
    int right = mid + 1;
    
    // pointer for temp array
    int k = 0;

    // variable to count inversion
    int count = 0;

    // merge elements in ascending order
    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp[k++] = arr[left++];
      }
      else {
        temp[k++] = arr[right++];
        count += (mid - left + 1);
      }
    }

    // copy remaining elements from left half
    while (left <= mid) {
      temp[k++] = arr[left++];
    }

    // copy remaining elements from right half
    while (right <= high) {
      temp[k++] = arr[right++];
    }

    // finally copying temp array into original array
    for (int i = low; i <= high; i++) {
      arr[i] = temp[i - low];
    }

    return count;
  }

  public static int mergesort(int[] arr, int low, int high) {
    int count = 0;
    // base case
    if( low >= high) {
      return count;
    }

    int mid = low + (high - low)/2;

    // count inversion in left half
    count += mergesort(arr, low, mid);
    // count inveriosn in right half
    count += mergesort(arr, mid + 1, high);

    // count inversion during merge
    count += merge(arr, low, mid, high);

    return count;
  }

  public static int inversionCount(int arr[]) {
    return mergesort(arr, 0, arr.length-1);
  }

  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 1};

    System.out.println("Total Inversion " + inversionCount(arr) );

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
  }
}