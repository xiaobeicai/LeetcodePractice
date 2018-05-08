/*Description#172
 * Given an integer n, return the number of trailing(后面的) zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeros {
	/*超时
	 * 
	 */
	public int trailingZeroes(int n) {
	 //就计算5的倍数即可
		int sum = 0;
		for(int i = 5;i <= n;i +=5) {
			int count = 0;
			do{
				count++;
				i /= 5;
			}while(i % 5 == 0);
			sum += count;
		}
		
		return sum;
        	
    }
	/*T~logN
	 * 
	 */
	public int trailingZeroes2(int n) {
		if(n == 0) return 0;
		
		return n/5 + trailingZeroes2(n/5);
	        	
	    }
}
