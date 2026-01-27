// 1.直接遍历两次删
// 2.栈
// 3.快慢指针

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
// 1.直接遍历两次
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        ListNode cur = head;
        ListNode pre = new ListNode(-10000);
        pre.next = cur;
        for (int i = 0; i < count - n; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        if (count == n) {
            return head.next;
        } else {
            return head;
        }
        
    }
}

// 2.栈

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        for (int i = 0; i < n; i++) {
            tmp = stack.pop();
        }
        if (stack.isEmpty()) {
            return head.next;
        }

        ListNode pre = stack.peek();
        pre.next = tmp.next;
        return head;
    }
}

// 3.快慢指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode cur = head;
        ListNode pre = new ListNode(-10000, head);
        ListNode ans = pre;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        return ans.next;


    }
}