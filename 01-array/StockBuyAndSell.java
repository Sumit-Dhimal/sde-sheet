

/**
 * Brute force solution
 * 
 * 1. find every possible profit buy compairing element at first with element coming after.
 * 2. after finding current profit compare with actual profit.
 * 3. If acutal profit is less than current profit than update it.
 * 
 * Time Complexity: O(N^2)
 * 
 */


/**
 * Better approach
 * 
 * 1. Buy the first element.
 * 2. Initialize another pointer j = i + 1.
 * 3. then compare bought price with prices at j
 *    if bought price is less than prices at j:
 *       we will get profit. So, find currProfit and update
 *    else if the new prices are cheaper:
 *      we will buy at that price, because prices is lower than when we bought, so we will get more profit.
 * 
 *      
 */

public class StockBuyAndSell {

  public static int maxProfit(int[] prices) {
    int profit = 0;
    int buy = prices[0];

    for(int i = 0; i < prices.length-1; i++) {

      int j = i+1;
      int currProfit = 0;

      // sell
      if(buy < prices[j]) {
        currProfit = prices[j] - buy;
        profit = Math.max(profit, currProfit);
      } else {
        buy = prices[j];
      }
    }

    return profit;
  }

  public static void main(String[] args) {
    int[] nums = { 7, 1, 5, 3, 6, 4 };

    int res = maxProfit(nums);
    
    System.out.println(res);
  }
}


