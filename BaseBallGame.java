import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

/*Description#682
 * You're now a baseball game point recorder.
 * Given a list of strings, each string can be one of the 4 following types:
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * You need to return the sum of the points you could get in all the rounds.
 * Example 1:
 * Input: ["5","2","C","D","+"] Output: 30
 * Explanation: 
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.  
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 * Example 2:
 * Input: ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation: 
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get -2 points. The sum is: 3.Round 3: You could get 4 points. The sum is: 7.
 * Operation 1: The round 3's data is invalid. The sum is: 3.  
 * Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
 * Round 5: You could get 9 points. The sum is: 8.
 * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 * Round 7: You could get 9 + 5 = 14 points. The sum is 27.
 * Note:
 * The size of the input list will be between 1 and 1000.
 * Every integer represented in the list will be between -30000 and 30000.
 */
public class BaseBallGame {
	
	/* 暴力方法
	 * 不可行，因为有可能有无尽的C
	 * 所以一定要用数据结构储存保留所有的数值
	 * 
	 */
		public int calPointsBrute(String[] ops) { //False
			int lasttwo = 0;
			boolean flagone = false; //是否存在lastone
			boolean flagtwo = false; //是否存在lasttwo
			boolean negative =false; //输入的数字是否为负数；
			int lastone = 0;
			int size = ops.length;
			int score = 0;
			for(int i = 0;i < size;i++) {
				char[] ch = ops[i].toCharArray();
				int j = 0;

				if(ch[0] == '-' ||(ch[0] >= '0' && ch[0] <= '9')) {//为数字
					if(ch[0] == '-') {
						negative = true;
						j++;
					}
					
					if(flagone) {
						lasttwo = lastone;
						flagtwo = true;
					}
                    lastone = ch[0] - '0';
                    flagone = true;
                    
					if(negative)
						lastone = -lastone;
					
					flagone = true;
					score += lastone;
					continue;
				}
				if(ch[0] == 'C') {
					score -= lastone;
					if(!flagtwo)
						flagone = false;
					else {
						lastone = lasttwo;
						flagtwo = false;
					}
					continue;
				}
				if(ch[0] == '+') {
					int temp = lastone + lasttwo;
					score += temp;
					lasttwo = lastone;
					lastone = temp;
					flagone = true;
					flagtwo = true;
					continue;
				}
				if(ch[0] == 'D') {
					int temp = 2 * lastone;
					score += temp;
					if(flagone)
						lasttwo = lastone;
					lastone =  temp;
					flagone = true;
					continue;
				}
				
			}
			return score;
	        
	    }
		
	/*Stack 后进先出 78%
	 * String类型比较要用equals，不能用== ！！！！ equals判断的字符串的内容，== 判断的是字符串的地址，不可混淆！！
	 * Integer.parseInt(str) or Integer.valueOf(str)将string转化为int
	 */
		public static int calPoints(String[] ops) {
			Stack<Integer> stack = new Stack<Integer>();
			int score = 0;
			
			for(String str: ops) {
				if(str.equals("+")) {
					stack.push(stack.peek() + stack.get(stack.size()-2));
					score += stack.peek();
					continue;
				}
				else if(str.equals("D")) {
					stack.push(stack.peek() * 2);
					score += stack.peek();
					continue;
				}
				else if(str.equals("C")) {
					score -= stack.pop();
					continue;
				}
				else {
					stack.push(Integer.parseInt(str));
					score += stack.peek();
				}
			}
			return score;
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String[] a = {"5","2","C","D","+"};
			int res = calPoints(a);
	        	StdOut.print("result:" + res);

		}
}
