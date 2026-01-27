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

// 快慢指针,需要数学推导公式相遇点和环点的关系
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if( fast != null) {
                fast = fast.next;
            }
            if (slow == fast && slow != null) {
                ListNode ans = head;
                while (ans != slow) {
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    
    }
}