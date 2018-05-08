/*Description:717
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

Example 1:
Input: 
bits = [1, 0, 0]
Output: True
Explanation: 
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
Example 2:
Input: 
bits = [1, 1, 1, 0]
Output: False
Explanation: 
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
Note:

1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.
 */
public class OneBItOrTwoBitCharacters {
	/*90%
	 * 00 10 
	 *10: 
	 *1:010 110true  
	 *2:1110 false 11110
	 */
	public boolean isOneBitCharacter(int[] bits) {
		int size = bits.length;
        if(size == 1 ) return true;
		if(bits[size-2] == 0) return true;
		else {
			int i = 1;
			 while(i>=0 && bits[size - 1-i]!=0)
				 i--;
			 return ((i%2)==1);
		}
			  
		   }
		
	
	/*T~N S~1
	 * When reading from the i-th position, if bits[i] == 0, 
	 * the next character must have 1 bit; else if bits[i] == 1, the next character must have 2 bits.
	 * We increment our read-pointer i to the start of the next character appropriately. 
	 * At the end, if our pointer is at bits.length - 1, then the last character must have a size of 1 bit.
	 */
	
	public boolean isOneBitCharacter2(int[] bits) {
		int size = bits.length;
		int i = 0;
		while(i < size - 1) 
			i += bits[i]+1;
		
		return (i==size-1);
    }
	
	/*Greedy
	 * 
	 */
}
