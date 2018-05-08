import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dataStructure.ListNode;

/*#141
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
	/*Hashset T~N S~N;
	 *只有一个参数的时候用HashSet
	 *有两个参数的时候用HashMap
	 */
	public boolean hasCycle(ListNode head) {
        Set<ListNode> map = new HashSet<ListNode>();
        ListNode node = head;
        while(node != null) {
    		if(map.contains(node))
    			return true;
    		map.add(node);
    		node = node.next;
        }
        
        return false;
    }
	/*TwoPointers T~N S~1
	 * 有cycle的话就fast最终会追上slow
	 */
	
	public boolean hasCycle2(ListNode head) {
		if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while(fast.next != null) {
        		slow = slow.next;
        		fast = fast.next;
        		if(fast.next != null)
        			fast = fast.next;
        		else
        			break;
        		if(fast == slow)
        			return true;
        }
        return false;
    }
	
	
}
