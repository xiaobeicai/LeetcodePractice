import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Description #46
 * Given a collection of distinct numbers, return all possible permutations.
 * For example:
 * [1,2,3] have the following permutations:[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 */
public class Permutation {
	/*Attention
	 * ArraList<>()之间的格式转换
	 */
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(nums);
	        backtrack(res,new ArrayList<>(),nums);
	        return res;
	    }
		private void backtrack(List<List<Integer>> res,List<Integer> list,int[] nums) {
			if(list.size() == nums.length)
				res.add(new ArrayList<>(list));
			else {
				for(int i = 0;i < nums.length;i++) {
					if(list.contains(nums[i])) continue;
					list.add(nums[i]);
					backtrack(res,list,nums);
					list.remove(list.size() - 1); //精髓
				}
			}
		}
		
		
	/*更快的算法：swap
	 * 但是看不懂。。。
	 */
}
