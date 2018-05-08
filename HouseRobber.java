/*Description
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 */
public class HouseRobber {
	
	/*毫无思路  T~N S~1
	 * sub problem is dp[i] = Math.Max(dp[i-1],dp[i-2]+num[i])
	 * 在simpler problem的基础上进行改动，只可能有两种最优解，0～length-2 or 1～length-1
	 */
	 public int rob(int[] nums) {
			int size = nums.length;
			if(size == 0) return 0;
			if(size == 1) return nums[0];
	        if(size == 2) return Math.max(nums[0],nums[1]);
	      return Math.max(robRange(nums,0, nums.length-2),robRange(nums,1,nums.length-1));
	    }
		private int robRange(int[] nums, int lo,int hi) {
			int[] dp = new int[hi - lo +1];
			dp[0] = nums[lo];
	        dp[1] = Math.max(nums[lo],nums[lo+1]);
			for(int i = 2; i <= hi - lo;i++) 
				dp[i] = Math.max(dp[i-1], dp[i-2] + nums[lo+i]);
			
			return dp[hi - lo];
		}
}
