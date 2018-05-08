import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.Node;

/*Description#213
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery 
 * so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 */
public class HouseRobberII {
	public int rob(int[] nums) {
		int size = nums.length;
		if(size == 0) return 0;
		if(size == 1) return nums[0];
      return Math.max(robRange(nums,0, nums.length-2),robRange(nums,1,nums.length-1));
    }
	private int robRange(int[] nums, int lo,int hi) {
		int[] dp = new int[hi - lo +1];
		dp[0] = 0;
		dp[1] = nums[lo];
		for(int i = lo+2; i <= hi;i++) 
			dp[i-lo] = Math.max(dp[i-lo+1], dp[i-lo] + nums[i]);
		
		return dp[hi - lo];
	}
}
