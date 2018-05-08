import java.util.ArrayList;
import java.util.List;

/*Description#728
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * Example 1:
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumber {
	
	/*List<Integer> list =  new ArrayList() or new ArrayList<>();
	 * 
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList();
		for(;left <= right;left++) {
			int temp = left;
			boolean flag = true;
			while(temp != 0) {
				if(temp % 10 == 0 || left %(temp%10) != 0) {
					flag = false;
					break;
				}
				else temp /= 10;
			}
			if(flag)
			list.add(left);
		}
		
        return list;
    }
}
