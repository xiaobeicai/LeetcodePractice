import edu.princeton.cs.algs4.StdOut;

public class PalindromeNumber { //9
	/*Description
	 * Determine whether an integer is a palindrome. Do this without extra space.(回文)
	 */
	
	/*Solution
	 * ReverseInteger变形
	 * 不能用pow函数，因为pow函数本身是用循环做的
	 * 负数肯定不是回文
	 * 调试才发现的错误：每一次循环x的值改变，最后结果不能直接 res == x判断
	 * 如果reverse后溢出则input肯定不是回文：因为输入的int都是在范围内的，一旦reverse超过范围，意味着不是原来的数字
	 * extra space usually means O(n) extra space.
	 */
	
	/*Improvement
	 * 简化while要求
	 */
	 public static boolean isPalindrome(int x) { //运行时间还是这个快，可能是因为return处不需要进行多余的判断
		 int res = 0;
		 int z = x;
		 while(x != 0) {  
			int y = x % 10;
			int prev = res;
			res = res * 10 + y;
			if(((res - y)/10) != prev)
				return false;
			x /= 10;
		 }
		 
		 if( res == z)
			 return true;
		 else return false;
		 
	    }
	 /*
	  * T~log10 N
	  * S~1
	  * 注意讨论10的倍数->一定是false，不提前判断进入循环，结果会变true(从纯数值角度考虑确实为true，但不是回文)
	  */
	 public static boolean isPalindromeBetter(int x) {
		 if(x < 0|| (x != 0 && x%10 == 0))
			 return false;
		 int res = 0;
		 while(x > res) {
			 res = res * 10 + x % 10;
			 x /= 10;
		 }
		 return (res == x || x == (res / 10));
		 
	    }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			String res = "True";
			boolean flag = isPalindrome(1);
			if(!flag)
				res = "False";
	        	StdOut.print("result:" + res);

		}
}
