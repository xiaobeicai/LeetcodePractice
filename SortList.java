import dataStructure.ListNode;
import edu.princeton.cs.algs4.StdOut;

/*Description#148
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
/* mergesort 63.5%
 * 
 */
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		
	       ListNode pre = null,slow = head, fast = head.next;
	       while(fast != null && fast.next != null) {
	    	   	pre = slow;
	    	   	slow = slow.next;
	    	   	fast = fast.next.next;
	       }
	       //slow = 2, fast = null;
	       fast = slow.next;
	       slow.next = null;
	       ListNode l1 = sortList(head);
	       ListNode l2 = sortList(fast);
	       
	       return merge(l1,l2);
	        
	    }
		private static ListNode merge(ListNode l1, ListNode l2) {
			ListNode l = new ListNode(0), p = l;
			while(l1 != null || l2 != null) {
				if(l2 == null) {
					p.next = l1;
					l1 = l1.next;
				}
				else if(l1 == null) {
					p.next = l2;
					l2 = l2.next;
				}
				else if(l1.val < l2.val) {
					p.next = l1;
					l1 = l1.next;
				}
				else{
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			}
			return l.next;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = new ListNode(3);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		root.next = a;
		a.next = b;
		ListNode res = sortList(root);
        	StdOut.print("result:" + res);

	}
}
