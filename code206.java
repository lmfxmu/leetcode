// 1.迭代
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
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode pre = null;
        ListNode cur = head;
        ListNode nex = null;

        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}

// 2.递归
class Solution {
    // 核心:明确未排序的链表和已排序的链表操作顺序
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        // 处理下一个子问题 head:未反转的当前节点
        // cur:已排序链表的最后一个节点（处理完之后）
        ListNode cur = reverseList(head.next);
        // 反转操作
        head.next.next = head;
        // 防止无限循环
        head.next = null;
        // 返回已排序链表的最后一个节点,(尾插法)，
        // 原写法是cur，但其实写head也对，被这个误导了很久
        return cur;

    }
}

// 2.递归，为了想清楚这个问题想了很久，其实那题反转链表
// 根本不用这么复杂，直接void函数就可以了，这个返回值纯没事找事
// 判断终点在哪里然后直接操作，他的返回值纯脱裤子放屁，为了返回而返回
// 不返回也根本没事
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = head;
        ListNode fast = head;
        boolean ans = true;
        // 找到中间节点
        while (fast.next != null) {
            pre = pre.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode test = reverse(pre);
        pre = head;
        while (pre.next != null) {
            if (pre.val != fast.val) {
                ans = false;
                break;
            }
            pre = pre.next;
            fast = fast.next;
        }
        return ans;

    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // nex是已排序链表的最后一个
        // head是当前节点
        ListNode nex = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }

    


}