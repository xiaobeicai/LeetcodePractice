/*#152
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
	/*
	 * corner case:-2,3,4 与maxSUm 略有不同，需要多考虑一些
	 */
	public int maxProduct(int[] nums) {
        int size = nums.length, maxSoFar = nums[0], maxEndHere = nums[0], minEndHere = nums[0];
        for(int i = 1;i < size;i++) {
        		if(nums[i] < 0) {
        			int temp = maxEndHere;
        			maxEndHere = minEndHere;
        			minEndHere = temp;
        		}
        		maxEndHere = Math.max(nums[i], maxEndHere * nums[i]);
        		minEndHere = Math.min(nums[i], minEndHere * nums[i]);
        		
        		maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
}
