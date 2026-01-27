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


// 迭代限制版，限制在l1上
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int set = 0;
        ListNode head = l1;
        while (l1 != null && l2 != null) {

            l1.val = l1.val + l2.val + set;
            set = l1.val / 10;
            l1.val = l1.val % 10;

            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode(0);
            } else if (l1.next != null && l2.next == null) {
                l2.next = new ListNode(0);
            } else if (l1.next == null && l2.next == null && set == 1) {
                l1.next = new ListNode(1);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (set != 0) {
            l1 = new ListNode(1);
        }
        return head;
    }
}