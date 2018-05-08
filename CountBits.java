/*Description#338
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * Credits:
 * Special thanks to @ syedee for adding this problem and creating all test cases.
 */
public class CountBits {
/*
 * 长度
 * 64位：char1 short 2 int 4 long8 double8
 */
	
/*brute位运算方法 超时
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 */
	public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i = 1;i<num;i++) {
        		int count = 0;
        		int temp = 1;
        		int j = 0;
        		while(temp <= i) {
        			if((i & (temp<<j)) > 0)
        				count++;
        			j++;
        		}
        		res[i] = count;
        }
        return res;
    }
	
	/*找规律 二分法 3ms 85%
	 * 
	 */
	public int[] countBits2(int num) {
		 int[] res = new int[num+1];
	        res[0] = 0;
	        if(num==0) return res;
	        res[1] = 1;
	        if(num == 1) return res;
	        int j = 1;
	        int index = 0;
	        for(int i=2;i < num + 1;i++) {
	        		if(i == (1<<j)) {
	        			res[i] = 1;
	        			index = i;
	                    j++;
	        		}
	        		else
	        			res[i] =  res[i % index] + 1;
	        }
	        return res;
        
    }
	/*Bestone 2ms 99%
	 * 简易版位运算
	 */
	public int[] countBits3(int num) {
		int[] res = new int[num + 1];
	      for (int i = 1; i <= num; ++i)
	        res[i] = res[i>>1] + (i&1); //等于左移一格的1的数量 + 个位是否位1
	      return res;
       
   }
	
	
	
}
