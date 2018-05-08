import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Description
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/*Hashtable
 * Map<Integer,Integer> map = new HashMap<>();
 * twic num: put一次，remove一次
 * once num: put一次，不remove
 * map.ketSet().toArray(new Integer[0]);
 */
public class SingleNumber {
	//HashMap
	public int singleNumber(int[] nums) { //14%
		Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], 0);
        	}else{
        		map.remove(nums[i]);
        	}
        }  
        Integer[]a = map.keySet().toArray(new Integer[0]);
        return a[0];
    }
	
	/* ^运行速度快
	 * a^b^a = b
	 */
	 public int singleNumber2(int[] nums) { //80%
	        int res = 0;
	        for(int num : nums) {
	            res ^= num;
	        }
	        return res;
	    }
	 /*Array.sort  T~NlogN S~NlogN 不行
	  * 
	  */
	 public int singleNumber3(int[] nums) { //100%
	       Arrays.sort(nums);
	       int size = nums.length;
	       if(size==1)
	    	   	return nums[0];
	       for(int i = 0;i < size;i +=2) {
	    	   	if(nums[i] != nums[i+1])
	    		   return nums[i];
	    	   	continue;
	       }
	       return 0;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
