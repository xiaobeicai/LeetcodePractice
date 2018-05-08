import edu.princeton.cs.algs4.StdOut;

/*8
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 */
public class StringToInteger {
	public static int myAtoi(String str) {
        if(str.isEmpty()) return 0;
 		char[] ch = str.toCharArray();
        int i = 0;
        int flag = 1;
        while(i < ch.length && ch[i] == ' ')
        		i++;
        if(i == ch.length) return 0;
        
        if(ch[i] == '-') {
        		flag = -1;
        		i++;
        }
        else if(ch[i] == '+') i++;
        else if(!(ch[i] <= '9'&& ch[i] >= '0'))
        		return 0;
        
        int sum = 0,pre = sum;
        while(i < ch.length && ch[i] <= '9' && ch[i] >= '0') {
    		sum = sum * 10  + ch[i] - '0';
    		if(sum < 0  || (sum - ch[i] + '0')/10 != pre) {  //溢出立刻报错的
    			if(flag == 1) return Integer.MAX_VALUE;
    			else return Integer.MIN_VALUE;
    		}
    		pre = sum;
    		i++;
    }
    	return flag * sum;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "-01324000";
		int res = myAtoi(str);
        	StdOut.print("result:" + res);

	}
}
