/*Description#14
 * Write a function to find the longest common prefix string amongst an array of strings.
 * For example:
 * {“a”,“a”,“b”} should give “” as there is nothing common in all the 3 strings.
 * {“a”, “a”} should give “a” as a is longest common prefix in all the strings.
 * {“abca”, “abc”} as abc
 * {“ac”, “ac”, “a”, “a”} as a.
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return new String(); //corner case
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < strs[0].length();i++) {
        		char ch = strs[0].charAt(i);
        		int j  = 1;
        		for(;j < strs.length;j++)
        			if(strs[j].length() <= i || ch != strs[j].charAt(i)) //!!!!corner case
        				break;
        		if(j == strs.length)
        			sb.append(ch);
        		else
        			break;
        }
        return sb.toString();
        	
    }
}		
