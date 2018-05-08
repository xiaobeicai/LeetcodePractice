import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class isYoungTableau {
	public boolean isYoungTableau(int[][] a) {
		boolean flag = true;
		for(int i = 0;i < a.length && flag;i++) {
			for(int j = 0;j < a[i].length && flag;j++) {
				if(j != a[i].length-1 && a[i][j] < a[i][j+1])  //3
					flag = false;
				if(i != 0 && a[i][j] < a[i-1][j])//4
					flag = false;
			}
			if(i!=0 && a[i].length < a[i-1].length)//2
				flag = false;
		}
		
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.print("Please input the times and data:");
		int time = StdIn.readInt();
		for(int i = 0;i < time;i++) {
			int[][] a  = new int[10][10];
			StdIn.readInt()
			else StdOut.print("No");
		}
	}
}
