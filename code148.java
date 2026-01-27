// 基本上没想出来，逻辑复杂一点马上宕机了


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

// 1.自顶向下分治   归并排序写了很久，还是不太熟悉，有更好的归并写法

class Solution {
    public ListNode sortList(ListNode head) {

        return merge(head);
        
    }

    // 将一个链表从终点拆分成两个链表，返回右边链表的head
    public ListNode midNode(ListNode left) {
        ListNode pre = left;
        ListNode slow = left;
        ListNode fast = left;
        while (fast != null && fast.next != null ) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            
        }
        pre.next = null;
        return slow;
    }
    public ListNode merge(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode right = midNode(head);
        head = merge(head);
        right = merge(right);
        ListNode pre = new ListNode(-10000);
        ListNode ans = pre;
        ListNode head1 = head;
        ListNode head2 = right;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pre.next = head1;
                head1 = head1.next;
                pre = pre.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
                pre = pre.next;
            }
        }
        pre.next = (head1 == null) ? head2 : head1;
        ListNode ansans = ans.next;
        ans.next = null;
        return ansans;
    }
}

// 2.自底向上  感觉也挺脱裤子放屁，无非是用长度这个变量来替代递归