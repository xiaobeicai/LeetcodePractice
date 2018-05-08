/*Description:#66
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
        int size = digits.length;
        
        if(digits[size-1] < 9) {
			digits[size-1]++;
			return digits;
		}
        
        for(int i = size -  1;i >= 0;) {
        		while(digits[i] == 9 && i>0) 
        			digits[i--] = 0;
        		
        		if(digits[i] != 9) {
        			digits[i] = digits[i] + 1;
        			break;
        		}
        		else {
        			int[] res = new int[size+1];
        			res[0] = 1;
        			for(int j=1;j < size+1;j++)
        				res[j] = digits[j-1];
        			return res;
        			}
        }
        
        return digits;
    }
	
	/*concise one
	 * 
	 */
	public int[] plusOneConcise(int[] digits) {
		int size = digits.length;
        
        for(int i = size -  1;i >= 0;i--) {
        		if(digits[i] < 9) {
    			digits[i]++;
    			return digits;
        		}
        		
        		digits[i] = 0;
        }
        int[] newDigits = new int[size+1];
        newDigits[0] = 1; //剩余部分初始化均为0
        
        return newDigits;
    }
}
