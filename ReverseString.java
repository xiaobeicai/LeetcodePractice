import edu.princeton.cs.algs4.StdOut;

/*Description
 * Write a function that takes a string as input and returns the string reversed.
 * Example:Given s = "hello", return "olleh".
 */

/*Solution
 * 不能用pow，本身复杂度为N？
 * char.toString 得到对于数组，调用toString()的默认实现是打印对象类型+hashCode()
 * char[] 数组为{‘1’,‘2’,‘3’,‘4’,‘5’,‘6’}用toString得到的是“[C@1270b73”  
 * char转化成String一般用new String(ch)
 */
public class ReverseString {
	public static String reverseString(String s) { //超时
		String rev = "";
        for(int i = s.length() ; i > 0; i-- )
        		rev = rev.concat(s.substring(i-1,i));
        
        return rev;
    }
	/*
	 * Time Complexity: `O(n)` (Average Case) and `O(n)` (Worst Case) where `n` is the total number character in the input string.
	 * Auxiliary Space: `O(n)` space is used where `n` is the total number character in the input string. 
	 */
	public static String reverseString1(String s) { 
		char[] ch = s.toCharArray();
		int i = 0;
		int j = s.length() -1;
		while(i < j) {
			char headtemp = ch[i];
			char tailtemp = ch[j];
			ch[i] = tailtemp;
			ch[j] = headtemp;
			i++;
			j--;
		}
		return new String(ch);
    }
	
	/*N;N
	 * void swap(int &a,int &b){
    		a=a^b;
    		b=b^a;
    		a=a^b;}
    	详解：
    		a1=a^b
		b=b^a1=b^a^b=a
		//此时a1=a^b  b=a
		a=a1^b=a^b^a=b
	 * Auxiliary Space: `O(n)` space is used where `n` is the total number character in the input string. 
	 */
	public static String reverseStringSwap(String s) { 
		char[] ch = s.toCharArray();
		int i = 0;
		int j = s.length() -1;
		while(i < j) {
			ch[i] = (char)(ch[i] ^ ch[j]);
			ch[j] = (char)(ch[j] ^ ch[i]);
			ch[i] = (char)(ch[i] ^ ch[j]);
		}
		return new String(ch);
    }
	/*time:
	 * `O(n log(n))` (Average Case) and `O(n * log(n))` (Worst Case) where `n` is the total number character in the input string. 
	 * The recurrence equation is `T(n) = 2 * T(n/2) + O(n)`. 
	 * `O(n)` is due to the fact that concatenation function takes linear time. 
	 * The recurrence equation can be solved to get `O(n * log(n))`.
	 * space:
	 * `O(h)` space is used where `h` is the depth of recursion tree generated which is `log(n)`. Space is needed for activation stack during recursion calls.
	 * Approach: Divide and Conquer (Recursive)
	 */
	
	public static String reverseString3(String s) { 
		int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = reverseString("hello");
		StdOut.print("result:" + res);
	}

}
