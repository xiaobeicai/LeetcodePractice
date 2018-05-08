import java.util.Arrays;

/*Description:#137
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumII {
	
	//Arrays.sort 基本类型用快速排序T～NlogN，S～logN，对象类型用归并 T～NlogN S～N
	//Error
	public int singleNumberError(int[] nums) {
		if(nums.length == 1) return nums[0];//corner case:1
        Arrays.sort(nums); //空间复杂度和时间复杂度都不符合
        int i = 0;
        for(;i < nums.length-1;i +=3) {//length - 1 corner case：1在最后
        if(nums[i] != nums[i+1])
        		break;
    }
        if(i == nums.length + 1)
        		return nums[nums.length-1];
        return nums[i];
	}
	/*位运算
	 * 
	 */
	public int singleNumber(int[] nums) {
		int size = nums.length;
		if(size == 1) return nums[0];//corner case:1
		int ones = 0,twos = 0,threes = 0;
		
		//以1出现三次为例理解
		for(int i = 0;i < size;i++) {
			twos |= ones & nums[i]; //两次为1
			ones ^= nums[i];  //碰到1次为1，两次为0，三次为1
			threes = ones & twos; //twos和ones均为1,则three为1
			ones &= ~threes; //three的相反数不会影响one
			twos &= ~threes;
		}
		
		return ones;
	}
}
