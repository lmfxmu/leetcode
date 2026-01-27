/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// Ä£Äâ
class Solution {
    ListNode tmptmp = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(-1000, head);
        ListNode cur1 = head;
        ListNode pre = ans;
        while (check(cur1, k)) {

            cur1.next = reverse(cur1, k);
            pre.next = tmptmp;
            pre = cur1;
            cur1 = cur1.next;
        }



        return ans.next;  
    }
    public boolean check(ListNode head, int k) {
        ListNode tmp = head;
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head, int k) {
        if (k == 1) {
            tmptmp = head;
            return head.next;
        }
        ListNode tmp = reverse(head.next, k-1);
        head.next.next = head;
        return tmp;
        
    }
}