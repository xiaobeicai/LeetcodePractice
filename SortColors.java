/*75
 *Given an array with n objects colored red, white or blue, 
 *sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *Note: You are not suppose to use the library's sort function for this problem.
 *Follow up:
 *A rather straight forward solution is a two-pass algorithm using counting sort.
 *First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 *Could you come up with an one-pass algorithm using only constant space? 
 */
public class SortColors {
	
	/*Two-Pass  Bucket Sort
	 * 
	 */
	public void sortColors(int[] nums) {
        int size = nums.length;
        if(size == 0) return;
        int red = 0, white = 0;
        //统计个数
        for(int i = 0;i < size;i++) {
        		if(nums[i] == 0) red++;
        		if(nums[i] == 1) white++;
        		nums[i] = 0;
        }
        for(int i = red;i < size;i++)
        		if(i < red + white)
        			nums[i] = 1;
        		else
        			nums[i] = 2;
}
	/*One-Pass
	 * 判断新球的种类，0放最前面，1，2依次，抽到0，就将所有index推后,
	 * red,white,blue记录各自颜色目前在nums里到的index
	 */
	public void sortColorsOnePass1(int[] nums) {
        int size = nums.length;
        if(size == 0) return;
        int red = 0, white = 0,blue = 0;
        
        for(int i = 0;i < size;i++) {
        	if(nums[i] == 0) {
        		nums[blue++] = 2; nums[white++] = 1; nums[red++] = 0; 
        	}
        	else if(nums[i] == 1) {
        		nums[blue++] = 2; nums[white++] = 1;
        	}
        	else nums[blue++] = 2;
        }       
}
	/*待考证
	 * 2，2  blue会到-1 
	 */
	public void sortColorsOnePass2(int[] nums) {
        int size = nums.length;
        if(size == 0) return;
        int red = 0, blue = size-1;
        
        for(int i = 0;i < size;i++) {
        		if(nums[i] == 0 && i != red)
        			swap(nums[red++],nums[i--]);
        		else if(nums[i] == 2 && i != blue)
        			swap(nums[blue--],nums[i--]);
        }       
}
	//Java传递的是拷贝副本，无法改变原值，可用异或解决
	private void swap(int a, int b ) {
		a^=b; 
		b^=a; 
		a^=b;
	}
	
}
