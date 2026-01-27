// 1.暴力搜索，哈希表，既然用暴力了就可以上哈希表不用傻傻每次遍历
// 2.找规律：双指针两次遍历
// 3.标记，看题目中都是正值，可以加上可逆标记例如负号

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 1.暴力搜索，哈希表
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        Set<ListNode> res = new HashSet<ListNode>();
        while (pa != null) {
            res.add(pa);
            pa = pa.next;
        }
        pa = headB;

        while (pa != null) {
            if (res.contains(pa)) {
                return pa;
            }
            pa = pa.next;
        }
        return pa;
    }
}


// 2.双指针
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = (pa == null) ? headB : pa.next; 
            pb = (pb == null) ? headA : pb.next; 
        }

        return pa;
    }
}
