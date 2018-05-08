import java.util.ArrayList; //应导入util内的包而不是awt
import java.util.List;
import java.util.Stack;

/*#22
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses {
	/*backtracking T~... S~...
	 * 
	 */
	
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		addString(list,"",0,0,n);
		return list;
    }
	private void addString(List<String> list, String str, int open, int close, int max) {
		if(str.length()  == 2 * max) {
			 list.add(str);
			 return;
		}
		
		if(open < max) 
			addString(list,str + "(",open+1,close,max);
		if(close < open)
			addString(list,str + ")",open,close+1,max);
		return;
	}
}
