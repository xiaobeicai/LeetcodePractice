import dataStructure.ListNode;

/*Description#2
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 */
public class AddTwoNum {
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	if(l1.val == 0 && l1.next == null) return l2;
	if(l2.val == 0 && l2.next == null) return l1;
	ListNode sum = new ListNode(0);
	ListNode head = sum;
	int carry  = 0;
	
     while(l1 != null || l2 != null) { 
    	 	ListNode digit;
    	 	if(l1 != null && l2 != null) {
    	 		digit = new ListNode((l1.val + l2.val + carry)%10); //不是直接取和，而是取余
    	 		carry = (l1.val + l2.val + carry)/10;
    	 		l1 = l1.next;
    	     	l2 = l2.next;
    	 	}
    	 	else if(l1 == null) {
    	 		digit = new ListNode((l2.val + carry)%10);
    	 		carry = (l2.val + carry)/10;
    	 		l2 = l2.next;
    	 	}
    	 	else {
    	 		digit = new ListNode((l1.val + carry)%10);
    	 		carry = (l1.val + carry)/10;
    	 		l1 = l1.next;
    	 	}
    		sum.next = digit;
    		sum = sum.next;
     }
     
     if(carry > 0) {
    	 	ListNode node = new ListNode(carry);
    	 	sum.next = node;
     }
     return head.next; //head是最初的sum，即first digit
    }
}
