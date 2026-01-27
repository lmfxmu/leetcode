/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 简单的快慢指针
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;;
        if (head != null) {
            fast = head.next;
        }
        
        while (fast != null) {
            if(slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if( fast != null) {
                fast = fast.next;
            }
        }
        return false;
    }
}