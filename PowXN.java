/*Description:#50
 *Implement pow(x, n).
 *Example 1:
 *Input: 2.00000, 10
 *Output: 1024.00000
 *Example 2:
 *Input: 2.10000, 3
 *Output: 9.26100 
 */
public class PowXN {
	//Brute force T~N S~1
	public double myPow(double x, long n) {
		 if(x == 0 || x == 1 || n == 1) return x;
		 if(n < 0) {
			 n = -n;
			 x = 1/x;
		 }
		 double res = 1.0;
		 for(;n > 0;n--) {
			 res *= x;
		 }
		 return res;
	 }
	/*Recursive T~logN S~logN
	 * corner case: n = 0, 1; x = 1
	 * 负数：
	 */
	 public double myPow2(double x, long n) {
		 if(x == 0 || x == 1 || n == 1) return x;
		 if(n == 0) return 1.0;
		 if(n < 0) { //负数统一处理
			 n = -n;
			 x = 1/x;
		 }
		 
		 if(n%2 == 0) return myPow(x * x,n / 2);
		 else return x * myPow(x * x,n / 2);
	 }
	 /*Iterative T~logN S~1
	  * 
	  */
	 public double myPow3(double x, long n) {
		 if(x == 0 || x == 1 || n == 1) return x;
		 if(n == 0) return 1.0;
		 if(n < 0) { //负数统一处理
			 n = -n;
			 x = 1/x;
		 }
		 double res = 1;
		 for(;n > 0; n /= 2) {
			 if(n%2 == 1)
				res *= x;
                 x = x * x;
		 }
		 return res;
	 }
	      
}
