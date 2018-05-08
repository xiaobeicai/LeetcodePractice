/*Description:#122
 * Say you have an array for which the ith element is the price of a given stock on day i
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int size = prices.length;
        if(size==1) return prices[0];
		int i = 0;
		int minprice = 0;
		int maxprofit = 0;
		
		while(i < size) {
			while(i < size - 1 && prices[i+1] <= prices[i])i++;
			minprice = prices[i++]; //记得i需要进行++防止
			while(i < size - 1 && prices[i+1] >= prices[i])i++;
			if(i < size)
			maxprofit += prices[i++] - minprice;
			//记得再进行i++，sell和buy不能在同一天
		}
		
		return maxprofit;
			
    }
}
