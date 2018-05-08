/*Description
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 */

/*位运算 位运算比数学运算快，可用于代码优化
 * &：两位同时为“1”，结果才为“1”，否则为0
 * 或：参加运算的两个对象只要有一个为1，其值为1。
 * ^异或：参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。
 * sum = a^b;
 * carry = (a&b) <<1;
 * 循环直至最后其中之一为0
 *一个数 and 1的结果就是取二进制的最末位。这可以用来判断一个整数的奇偶，二进制的最末位为0表示该数为偶数，最末位为1表示该数为奇数。 
 *xor运算的逆运算是它本身，也就是说两次异或同一个数最后结果不变，即（a xor b) xor b = a。
 */
public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
      if(a == 0) return b;
      if(b == 0) return a;
      int sum = a^b;
      int carry = (a&b)<<1;
      return getSum(sum,carry);
    }
}
