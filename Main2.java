import java.util.Scanner;

public class Main2 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        for(int i = 0;i < n;i++) {
	        		int k = sc.nextInt();
	        		int res = count(k);
	        		System.out.println(res);
	        }
	       
	    }
	    public int cal(int N,int n,int m,int p) {
	    	int[] a = new int[N+1];
	    	a[1] = p;
	    	for(int i = 2;i < N+1;i++)
	    }
	     public static int gcd(int i,int j) {
	    	 int gcd = 1;
	    	  for(int k = 2;k < i/gcd;k++) 
	    		  if(i % k == 0 && j % k == 0)
	    			  gcd *= k;
	    	  
	     return gcd;
	     }
}
