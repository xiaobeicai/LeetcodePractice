import java.util.Stack;

/*Description:#227
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorII {
	public int calculate(String s) {	
		 Stack<Integer> stack = new Stack<Integer>();
	        int res = 0;
	        for(int i = 0, num = 0,op ='+';i < s.length();i++) {
	                char ch = s.charAt(i);
	        		if(Character.isDigit(ch))
	        			num = num * 10 + ch - '0';
	        		if(ch == '+' || ch == '-' ||  ch == '*' || ch == '/' || i == s.length()-1) {
	        			if(op == '*' || op == '/')//碰到* ／，需要把之前的数取出，之前默认为+
	        				res -= stack.peek();
	        			switch(op) {
	        			case '+':
	        				stack.push(num);
	        				break;
	        			case '-':
	        				stack.push(-num);
	        				break;
	        			case '*':
	        				stack.push(num * stack.pop());
	        				break;
	        			case '/':
	        				stack.push(stack.pop()/num);
	        				break;
	        			}
	        			res += stack.peek();
	        			num = 0;
	        			op = ch;
	        		}
	        }
	        
	        return res;
    }
	
	/*No stack
	 * 
	 */
	public int calculateNoStack(String s) {	
	        int res = 0;
	        for(int i = 0, num = 0,pre = 0,op ='+';i < s.length();i++) {
	                char ch = s.charAt(i);
	        		if(Character.isDigit(ch))
	        			num = num * 10 + ch - '0';
	        		if(ch == '+' || ch == '-' ||  ch == '*' || ch == '/' || i == s.length()-1) {
	        			if(op == '*' || op == '/')//碰到* ／，需要把之前的数取出，之前默认为+
	        				res -= pre;
	        			switch(op) {
	        			case '+':
	        				pre = num;
	        				break;
	        			case '-':
	        				pre = -num;
	        				break;
	        			case '*':
	        				pre = num * pre;
	        				break;
	        			case '/':
	        				pre = pre/num;
	        				break;
	        			}
	        			res += pre;
	        			num = 0;
	        			op = ch;
	        		}
	        }
	        
	        return res;
   }
	
	
}
