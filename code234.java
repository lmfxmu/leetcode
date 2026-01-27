// 快慢指针处理反转后的链表，问题是如何处理
// 1.额外空间记录，过于简单不写了
// 2.直接原结构上翻转，有好几种写法，迭代递归都行，递归是真麻烦

// 2.递归，自己写的，原写法真的看不懂
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
    ListNode pre = null;
    boolean ans = true;
    public boolean isPalindrome(ListNode head) {
        pre = head;
        reverse(head);
        return ans;
    }

    public void reverse(ListNode head) {

        if (head != null && pre != null) {
            reverse(head.next);
            if (pre.val != head.val) {
                ans = false;
            }
            pre = pre.next;
        }


    }
}