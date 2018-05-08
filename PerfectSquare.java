import java.util.HashMap;
import java.util.Map;

public class PerfectSquare {
	/*DP T~N2 S~N
	 * 
	 */
	public int numSquares(int n) {
		int[] dp = new int[n+1];
        int index = 2;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            if(i == (index * index)){
                dp[i] = 1;
                index++;
            }
            else
            {
            int min= Integer.MAX_VALUE;
            for(int j = 1;j <= i/2;j++){
               min = Math.min(dp[j] + dp[i-j],min);
            }
            dp[i] = min;
            } 
        }
        return dp[n];
	}
}
