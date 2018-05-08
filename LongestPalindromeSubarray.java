import edu.princeton.cs.algs4.StdOut;

/*#5
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromeSubarray {
	/*T~N2 worsecase:"aaaaaaaaaaaaa" = n2
	 * 
	 */
	private int max = 0;
	private char[] ch;
	private int left = 0;
	private int right = 0;
	public String longestPalindrome(String s) {
		int len = s.length();
		if(len < 2) return s;
		ch = s.toCharArray();
		for(int i = 0;i < len-1;i++) {
			extendPalindrome(i,i);//odd
			extendPalindrome(i,i+1);//even
		}
		
     return s.substring(left, right+1);
    }
	private void extendPalindrome(int left, int right) {
		while(left >= 0 && right < ch.length && ch[left] == ch[right]) {
				left--;
				right++;
		}
		left++;
		right--;
		int len = right - left + 1;
		if(max < len) {
			max = len;
			this.left = left;
			this.right = right;
		}
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaabaaaa";
		String res = longestPalindrome(a);
        	StdOut.print("result:" + res);

	}*/
}
