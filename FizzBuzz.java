import java.util.ArrayList;
import java.util.List;

/*Description:412
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */

/*Solution
 * List<String> list = new ArrayList<String>()
 * 如何将 int 转化为 String: String.valueOf(i)
 */

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		String three = "Fizz";
		String five = "Buzz";
		String multiples = "FizzBuzz";
        int i = 1;
		while(i <= n) {
			if (i % 15 == 0)
				list.add(multiples);
			else if(i % 3 == 0)
				list.add(three);
			else if(i % 5 == 0)
				list.add(five);
			else 
				list.add(String.valueOf(i));
			i++;
		}
		
		return list;
    }
	/*运行速度远大于第一个
	 * 不需要多次计算%取余
	 * ++方法速度快
	 */
	 public List<String> fizzBuzz2(int n) {
	        List<String> ret = new ArrayList<String>(n);
	        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
	            fizz++;
	            buzz++;
	            if(fizz==3 && buzz==5){
	                ret.add("FizzBuzz");
	                fizz=0;
	                buzz=0;
	            }else if(fizz==3){
	                ret.add("Fizz");
	                fizz=0;
	            }else if(buzz==5){
	                ret.add("Buzz");
	                buzz=0;
	            }else{
	                ret.add(String.valueOf(i));
	            }
	        } 
	        return ret;
	    }
}
