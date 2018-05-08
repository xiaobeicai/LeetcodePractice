import edu.princeton.cs.algs4.StdOut;

/*Description:#151
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 */
public class ReverseWordsInAString {
	/*整个Reserve后，单个reserve
	 * reverse.trim().split("\\s+");
	 */
	public String reverseWords(String s) {
		String reverse = reverse(s);
        String[] parts = reverse.trim().split("\\s+"); //“\\s+”专门用于切割 
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < parts.length;i++) {
        		sb.append(reverse(parts[i]));
        		if(i != parts.length-1)
        		sb.append(" ");
        }
       
        return sb.toString();
    }
	
	private String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1;i >= 0;i--) 
			sb.append(s.charAt(i));
		return sb.toString();
	}
	//in-place
	public static String reverseWords2(String s) {
		int size = s.length();
		if(s == null) return null;//corner cas
		char[] a = s.toCharArray();
		reverse(a,0,size-1);
		reverseWord(a,size);
		return cleanSpaces(a);
		
    }
	// trim leading, trailing and multiple spaces
	private static String cleanSpaces(char[] a) {
		int size = a.length;
		int i = 0,j = 0;
		
		while(j < size && i <size ) {
			while(j < size && a[j] == ' ')j++;
			while(j < size && a[j] != ' ')a[i++] = a[j++];
			while(j < size && a[j] == ' ')j++;
			if(j < size)
				a[i++] = ' ';
		}
		return new String(a).substring(0,i);//i之后的全为空格

	}
	private static void reverseWord(char[]a,int n) {
		int i = 0,j = 0;
		while(j < n) {
			while(i < n && a[i] == ' ')i++;
			j = i;
			while(j < n && a[j] != ' ' )j++;
			reverse(a,i,j-1);
		}
	}
	
	private static void reverse(char[] a,int lo,int hi) {
		
		while(lo < hi) {
			char temp = a[lo];
			a[lo++] = a[hi];
			a[hi--] = temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = " a ";
		String res = reverseWords2(a);
        	StdOut.print("result:" + res);

	}
}
