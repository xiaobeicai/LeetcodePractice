import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StringTest {

	public static boolean StringTest(String s) {
		StringBuilder sb;
		while(true) {
			int i = 0;
			sb = new StringBuilder();
			for(;i < s.length() - 1;i++) {
				char cur = s.charAt(i);
				char next = s.charAt(i+1);
				if(cur == next)
					continue;
				else
					sb.append(cur);
			}
			if(s == sb.toString())
				break;
			else {
			s = sb.toString();
			sb = new StringBuilder();
			}
		}
		
		return s.length() == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.print("Please input the times and data:");
		int time = StdIn.readInt();
		for(int i = 0;i < time;i++) {
			StringBuilder sb = new StringBuilder(StdIn.readLine());
			if(StringTest(sb.toString()))
				StdOut.print("Yes");
			else StdOut.print("No");
		}
	}
}
