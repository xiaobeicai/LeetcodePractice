import java.util.HashMap;
import java.util.Map;

/*Description
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MarjorityElement {
	/*HashTable 26ms
	 * T～N S~N
	 */
	public int majorityElement(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		int size = nums.length;
		for(int i = nums.length - 1; i > -1; i--) {
			if(!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else 
				map.put(nums[i], map.get(nums[i]) + 1);
            
            if(map.get(nums[i]) > size/2 )
					return nums[i];
		}
		
		return 0;
		
		
    }
	/*一种非常神奇的算法
	 * T～N
	 * S～1
	 */
	
	public int majorityElement2(int[] num) {
		int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
		
		
    }
}
