import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i < n;i++) {
        		int k = sc.nextInt();
        		int res = count(k);
        		System.out.println(res);
        }
       
    }
    
     public static int count(int n) {
    	 	if(n < 10) return n;
    	 	int a = (int) Math.log(n);
    	 	return a + count(n-1);
     }
}
