


public class find_power {

  public static double power(double x, long n) {
    // base case - I
    if (n == 0) return 1.0;

    // base case - II
    if (n == 1) return x;

    // if x is even
    if ( n % 2 == 0)
      return power(x * x, n / 2);

    // if x is odd 
    else 
      return x * power(x, n - 1);
  }

  public static double myPow(double x, int n) {
    // if n is negative
    long N = n;

    if ( N < 0) {
      x = 1/x;
      N = -N;
    }

    return power(x, N);
  }

  public static void main(String[] args) {
    double x =  2; 
    int n = -2;

    System.out.println(myPow(x, n));
  }
}

/**
 * Time Complexity: O(log n), where n is the absolute value of the exponent. This is because we reduce the problem size by half in each recursive call when n is even.
 * 
 * Space Complexity: O(log n), due to the recursive call stack. In the worst case, the depth of the recursion can go up to log(n) when n is even.
 */
