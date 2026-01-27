// 这一题挺难，比较简单的就是顺序合并和归并合并
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


// 顺序合并

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        int n = lists.length;
        if (n != 0) {
            ans = lists[0];
        }
        for (int i = 0; i < n - 1; i++) {
            lists[i+1] = mergetwoList(lists[i], lists[i+1]);
            ans = lists[i+1];
        }
        return ans;
    }

    public ListNode mergetwoList(ListNode a, ListNode b) {
        ListNode pre = new ListNode(-10000, a);
        ListNode cur = pre;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;
        return pre.next;
    }
}

// 迭代写法的分治合并需要背一背，第一次自己推没退出来
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        if (n == 0) {
            return null;
        }
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; i + j < n; j += i*2) {
                lists[j] = mergetwoList(lists[j], lists[j + i]);
            }
        }
        
        return lists[0];
    }

    public ListNode mergetwoList(ListNode a, ListNode b) {
        ListNode pre = new ListNode(-10000, a);
        ListNode cur = pre;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;
        return pre.next;
    }
}


// 分治递归写法，每次都要写半天
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        if (n == 0) {
            return null;
        }
        
    
        return func(lists, 0, n-1);
    }
    // 每次都写不出来
    public ListNode func(ListNode[] lists, int l, int r) {
        if (l >= r) {
            return l == r ? lists[l] : null;
        }
        int mid = (l + r) / 2;
        // 先切割
        ListNode left = func(lists, l, mid);
        ListNode right = func(lists, mid + 1, r);
        // 后合并
        return mergetwoList(left, right);
    }

    public ListNode mergetwoList(ListNode a, ListNode b) {
        ListNode pre = new ListNode(-10000, a);
        ListNode cur = pre;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;
        return pre.next;
    }
}


//  最小堆
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val );
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        ListNode ans = new ListNode(-10000);
        ListNode cur = ans;

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            if (cur.next.next != null) {
                queue.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return ans.next;

    }
}