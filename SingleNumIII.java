/*#260
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumIII {
	
	//负数的二进制是 其正数（原码）的反码+1（补码）
	public int[] singleNumber(int[] nums) {
        int size = nums.length;
        if(size == 2) return nums;
        int diff = 0;
        for(	int num:nums)
        	  diff ^= num;
        
        diff &= -diff;
        int[] res = {0,0};
        for(int num:nums) 
        		if((num&diff) == 0) res[0] ^= num;
        		else res[1]^= num;
        
        return res;
    }
}
