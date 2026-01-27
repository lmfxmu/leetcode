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


// 1.迭代
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(-1000, head);
        ListNode cur1 = head;
        ListNode cur2 = (head == null) ? null : head.next;
        ListNode pre = ans;
        while (cur1 != null && cur2 != null) {

            cur1.next = cur2.next;
            pre.next = cur2;
            cur2.next = cur1;

            pre = cur1;
            cur1 = cur1.next;
            if(cur1 != null) {
                cur2 = cur1.next;
            } else {
                cur2 = null;
            }

        }
        return ans.next;
    }
}

// 2.递归

class Solution {
    // 返回值：下一个链表的头结点
    public ListNode swapPairs(ListNode head) {
        // 解决完终点问题，再专注解决子问题
        if (head == null || head.next == null) {
            return head;
        }

        // 不是终点的时候子问题为2个节点+子问题操作
        ListNode newhead = head.next;
        head.next = swapPairs(head.next.next);
        newhead.next = head;

        return newhead;

    }
}