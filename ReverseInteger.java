
public class ReverseInteger {
	/*Description:
	 * Given a 32-bit signed integer, reverse digits of an integer.
	 */
	
	/*Solution
	 * test: 123 -123 10 overflow 
	 * minT~N 第一遍写成了2N; 超时是因为overflow，一直没想出，看了discussion才明白
	 * 尤其注意overflow 
	 * solu1：res != prevIf overflow exists, the new result will not equal previous one. 21,4748,3647
	 * solu2: 用long res存储反转后的值，再用Integer.MAX_VALUE/Integer.MIN_VALUE检验是否溢出，最后强制转换return (int)res; nextQ: what if input is long? No Answer.
	 */
	
	/*Question
	 * 负数可以取余么？
	 */
	
	 /*Improvement
	  * T: 2N->N
	  * Java不需要判断正负，负数可正常取余
	  * 不需要判断是否是10的倍数 因为 x%10 * 10 = 0
	  */
	 public int reverse(int x) {
		 boolean flag1 = true;
         boolean flag2 = false;
	        	if(x < 0 ){
	        		flag1 = false;
                 x = -x;
             }
     
	        	int res = 0;
	        	while(x != 0){
                 if(x % 10 == 0 && !flag2){
                     x /= 10;
                     continue;
                 }
                 flag2 = true;
                 int pre = res;
                 res = res * 10 + x % 10;
                 if((res - x%10)/10 != pre)
                     return 0;
                 x /= 10;
             }
	        	
	        	if(!flag1)
	        		res = -res;
	        	return res;
	    }
	 /*Answer
	  * 不同编译器不同(-7%3)；C++／Java正常-1 Python为2
	  */

}
