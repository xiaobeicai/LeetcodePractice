/*Description:58
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {
/*Solve
 * 考虑到
 * 
 */
	public int lengthOfLastWord(String s) {
		 int size = s.length()-1;
			int count = 0;
	        if(s.length() == 0)
	            return 0;
			while(s.charAt(size) == ' '){
	            if(size==0)
	                return 0;
	            size--;
	        }
			while(s.charAt(size) != ' ') {
				count++;
				if(size == 0)
					break;	
				size--;
			}
				
				return count;
    }
	/*more pratical, but may be not the one that interviewer want you to do
	 * 
	 */
	public int lengthOfLastWord2(String s) {
	    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}


}
