import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*#315
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
public class CountOfSmallerNumAfterSelf {
	/*超时 N2
	 * 
	 */
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList();
		int a = 1;
		a +=(a++);
		a += (++a);
		//(a++) += a;
		(++a) +=(a++);
		Integer b = new Integer(59);
		
        for(int i = 0;i < nums.length;i++) {//不能省略最后一个数
        		//list初始化为null，需要主动赋值
        		//list.add 不是replace，会使list变长，list没有replace单个的方法
        		int count = 0;
        		for(int j = i+1;j < nums.length;j++)
        			if(nums[j] < nums[i]) count++;
        		list.add(i,count);
        }
       
        return list;
    }
	/*超时 n2优化
	 * 
	 */
	public List<Integer> countSmaller2(int[] nums) {
		List<Integer> list = new ArrayList<Integer>(nums.length);
        for(int i = nums.length - 1;i>= 0;i--) {//不能省略最后一个数
        		int count = 0;
        		for(int j = i+1;j < nums.length;j++)
        			if(nums[j] < nums[i]) {
        				count += list.get(j) + 1;
        				list.add(i,count);
        				break;
        			}
        }
       
        return list;
    }
	
}
