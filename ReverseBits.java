import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

/*Description:#190
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	//无符号的 int 小于 2的32次方-1; 有符号的 int 小于 2的31次方-1
	//java不支持定义unsigned，除了char全是signed
	public static long reverseBits(int n) {
		int res = 0;
		for(int i = 0;i < 32;i++) {
			res <<= 1;
			res += (n&1);
			n >>= 1;
		}
        return res;
    }
	/*Optimization
	 *  We can divide an int into 4 bytes, and reverse each byte then combine into an int. For each byte, we can use cache to improve performance.
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tag = Long.
		long res = reverseBits(tag); //  2147483648 (100 000 000 000 000 000 000 000 000 000 00)
        	StdOut.print("result:" + res);

	}
}
