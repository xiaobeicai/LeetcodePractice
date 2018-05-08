import dataStructure.ListNode;

/*Description:#234
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	/*超时
	 * 
	 */
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode pre = null, cur = head;
        while(cur != null) {
        		ListNode nextNode = cur.next;
        		cur.next = pre;
        		pre = cur;
        		cur = nextNode;
        }
        while(pre != null || head != null)
        	if(pre.val != head.val) return false;
        
        return true;
    }
	/*Improvement on 1- Two Pointer： fast and slow
	 * T～N S～1(though someone said it is impossible to be 1)
	 */
	public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;//0 or 1
        if(head.next.next == null) return head.val == head.next.val;
        
        ListNode fast = head,slow = head;
        int count = 1;
        
        //find the middle, divide the list to left and right
        while(fast.next != null) {
        		slow = slow.next;
        		fast = fast.next; //cornercase [1,2]
            if(fast.next == null)
            		break;
            fast = fast.next;
            count++;
        }
        
        //reverse the right one
        ListNode pre = slow,cur = slow.next;
        while(cur != null) {
        		ListNode nextNode = cur.next;
        		cur.next = pre;
        		pre = cur;
        		cur = nextNode;
        }
        //comepare left and reserved right
        for(;count > 0 ; count--) {
        		if(pre.val != head.val)
        			break;
        		pre = pre.next;
        		head =  head.next;
        }
        
        return count == 0;
    }
}
