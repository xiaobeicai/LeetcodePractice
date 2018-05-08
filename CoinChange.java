import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Description:#322
 * 
 */
public class CoinChange {
	/*DP
	 */
	 public static int coinChange(int[] coins, int amount) {
		 int[] dp = new int[amount + 1];
		 for(int i = 1;i < amount + 1;i++)
			 dp[i] = Integer.MAX_VALUE;
		 dp[0] = 0;
		 for(int i = 1;i < amount + 1;i++) {
			 for(int j = 0;j < coins.length;j++) {
				 int temp = i/coins[j];
				 while(temp > 0){ //这一步特别关键，不是每一个coin都只取最大值进行减法，而是要一个个减
				    if( dp[i - coins[j] * temp] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i],dp[i - coins[j] * temp] + temp);
				    temp--; 
                 }
			 }
		 }
         return dp[amount] == Integer.MAX_VALUE? -1:dp[amount];
	 }
	 public static void main(String[] args) {
		 int[] coins = {186,419,83,408};
		 int amount = 6249;
		 int res = coinChange(coins,amount);
		 System.out.println("res:" + res);
	 }
}
