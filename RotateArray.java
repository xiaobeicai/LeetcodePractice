import java.util.Queue;

/*Description:#189
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * [show hint]
 * Related problem: Reverse Words in a String II
 * Credits:
 * Special thanks to @Freezen for adding this problem and creating all test cases.
 */
public class RotateArray {
	/*Brute one T~kn S~1
	 * 
	 */
	public void rotate(int[] nums, int k) {
		int size = nums.length;
		int ktemp = k%size;
		int temp,prev;
        for(int i = 0;i < ktemp ;i++) {
        	   prev = nums[size-1];
        		for(int j = 0;j < size;j++) {
        			temp = nums[j];
        			nums[j] = prev;
        			prev = temp;
        		}
        }
        			
    }
	/*double space T~N S~N
	 *！！k可能大于n，所以需要计算k%size
	 *！！数组之间不能直接赋值，需要for循环进行赋值
	 */
	
	public void rotateExtraSpace(int[] nums, int k) {
		int size = nums.length;
		int ktemp = k%size;
		int[] temp = new int[size];
        for(int i = 0;i < size ;i++) {
        		if(i < ktemp) 
        			temp[i] = nums[size + i - ktemp];
        		else
        			temp[i] = nums[i-ktemp];
        }
        
        for(int i = 0;i < size;i++)
        		nums[i] = temp[i];
    }
	
	/*循环数组!!! T~N  S~1
	 * 搞清楚逻辑
	 */
	
	public void rotateCycle(int[] nums, int k) {
		int size = nums.length;
		k = k % size;
		int count = 0;
		for(int start = 0; count < size; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k)%size;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			}while(start != current);
				
		}
    }
	//Reverse T~N S~1
	public void rotateReverse(int[] nums, int k) {
		int size = nums.length;
		k = k % size;
		reverse(nums,0,size-1);
		reverse(nums,0,k-1);
		reverse(nums,k,size-1);
    }
	private void reverse(int[]nums,int start, int end) {
			while(start < end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start++;
				end--;
			}
	}
}
