/*Description#55
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	/*超时
	 * 
	 */
	public boolean canJump(int[] nums) {
		int size = nums.length;
		if(size == 0 ) return false;
		if(size == 1) return true;
       return Jump(nums,0);
    }
	private boolean Jump(int[] nums, int i) {
		if(i >= nums.length -1 || i + nums[i] >= nums.length - 1) return true;
		for(int k = nums[i] ; k > 0;k--)
			if(Jump(nums,i + k))
				return true;
		return false;
	}
	
	public boolean canJump2(int[] nums) {
		int size = nums.length;
		if(size == 0 ) return false;
		if(size == 1) return true;
       return Jump(nums,size - 2);
    }
	private boolean Jump2(int[] nums, int i) {
		if(nums[i] >= nums.length - i) {
			Jump2(nums,i)
		}
		return false;
	}
	
	
}
