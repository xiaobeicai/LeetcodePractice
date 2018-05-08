/*Description#238
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
	/*总是在边界值处搞晕！！！
	 * 99%
	 */
	public int[] productExceptSelf(int[] nums) {
		int size = nums.length;
		int[] res = new int[size];
		int left  = 1;
        for(int i = 1;i < size;i++) {
        		left *= nums[i-1];
        		res[i] = left * nums[i]; //包含乘数nums[i]
        }
        
        res[0] = nums[0];
        int right = 1;
        
        for(int i = size-1;i >= 1; i--) {
        		res[i] = right * res[i-1];
        		right *= nums[i];
        }
        
        res[0] = right;
        
        return res;
        
    }
}
