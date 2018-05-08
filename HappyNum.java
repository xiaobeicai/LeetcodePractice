import java.util.HashSet;

/*Description#202
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 62
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNum {
	//set 29%
	public boolean isHappy(int n) {
       if(n==0)
    	   	return false;
       else if(n==1) return true;
      
       HashSet set = new HashSet();//拒接接受重复对象
       while(n != 1) {
    	   	if(set.contains(n))
	   			return false;
    	   	else {
    	   		set.add(n);
    	   		int temp = n;
    	   		int sum = 0;
    	   		while(temp != 0) {
    	   			sum += (temp%10) * (temp%10);
    	   			temp /=10;
    	   		}
    	   		n = sum;
    	   	}
       }
       return true;
    }
	
	
	//floid cycle al 82%
	//不管是不是happynum，任何数的各位平方之和一定会形成循环，只是不一定为1
	public boolean isHappyFloid(int n) {
	     int slow = n;
	     int fast = n;
	     do {
	    	 	slow = SquareSum(slow);
	    	 	fast = SquareSum(fast);
	    	 	fast = SquareSum(fast);
	     }while(slow != fast);
		
	     return slow==1;
	    }
	
	private int SquareSum(int n) {
		int sum = 0;
		while(n!=0) {
		   sum += (n%10)	*(n%10);
		   n /= 10;
		}
		return sum;
	}
}
