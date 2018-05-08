/*Description#121
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
	/*超时 T~N2 S~1;
	 * Bruteforce
	 */
	public int maxProfit(int[] prices) {
		int size = prices.length;
		int profit = 0;
        for(int i = 0;i < size-1;i++) {
        		int min = prices[i];
        		int max = prices[i+1];
        		for(int j = i+2;j < size;j++) 
        			if(prices[j] > max)
        				max=  prices[j];
        		if(max - min > profit)
        			profit = max - min;
        }
        
        return profit;
    }
	/*one pass T~N S~1
	 * 
	 */
	public int maxProfit2(int[] prices) {
		int size = prices.length;
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for(int i = 0; i < size;i++) {
			if(minprice > prices[i])
				minprice = prices[i];
			else if(prices[i] - minprice > maxprofit)
				maxprofit = prices[i] - minprice;		
		}
		
		return maxprofit;

        
        
    }
}
