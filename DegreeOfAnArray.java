import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*#697
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {
	/*HashMap T~N S~N
	 * 
	 */
	public int findShortestSubArray(int[] nums) {
		 int small = nums.length;
	        
	        Map<Integer,Integer> count = new HashMap<Integer,Integer>(), left = new HashMap<Integer, Integer>(), right = new HashMap<Integer,Integer>();
	         for(int i = 0;i < nums.length;i++) {
	        		if(!count.containsKey(nums[i])) {
	        			count.put(nums[i], 1);
	        			left.put(nums[i], i);
	        		}
	        		else{
	        			int val = count.get(nums[i])+1;
	        			count.put(nums[i], val);
	        		}
	             right.put(nums[i], i);
	         }
	         
	         int deep = Collections.max(count.values());
	   
	        for(int num:nums) 
	        	if(count.get(num) == deep)
	        		small = Math.min(small, right.get(num) - left.get(num) +1);
	       
	        return small;
    }
}
