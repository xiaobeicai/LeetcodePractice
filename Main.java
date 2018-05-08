import java.util.Arrays;
import java.util.Scanner;
public class Main {
	
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
    	 	int digit = 0;
    	 	int num = n;
    	 	while(num > 0) {
    	 		digit++;
    	 		num /= 10;
    	 	}
    	 	int sum = 0;
    	 	int min = (int)Math.pow(10, digit-1);
    	 	int b = 9;//个数
    	 	int count = 1; //个位数的1，两位数的2，
    	 	while(count < digit) {
    	 		sum += count * b;
    	 		b *= 10;
    	 		count++;
    	 	}
    	 	sum += (n-min + 1)*digit;
    	    while(n % 10 == 0) {
    	    	  n /= 10;
    	    	  sum--;
    	    }
    	    	
    	 	return sum;
     }
 
}
    