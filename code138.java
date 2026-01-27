/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// 回溯感觉太弯弯绕绕了，不准备写，虽然代码很简洁

// 1.只能想到哈希表
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<Node, Node>();
        Node tmp = head;
        copy.put(null, null);
        while (tmp != null) {
            if (!copy.containsKey(tmp)) {
                Node newNode = new Node(tmp.val);
                copy.put(tmp, newNode);
            }
            tmp = tmp.next;
        }
        Node newHead = copy.get(head);
        Node ans = newHead;
        tmp = head;
        while (tmp != null) {
            newHead.next = copy.get(tmp.next);
            newHead.random = copy.get(tmp.random);
            newHead = newHead.next;
            tmp = tmp.next;
            
        }
        return ans;
    }
}



// 交错链表
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node tmp = head;
        while (tmp != null) {
            Node tmp2 = new Node(tmp.val);
            tmp2.next = tmp.next;
            tmp.next = tmp2;
            tmp = tmp2.next;
        }
        tmp = head;
        
        while (tmp != null) {
            if (tmp.random != null) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        Node ans = head.next;
        tmp = head;
        while (tmp != null) {
            Node tmp2 = tmp.next;
            tmp.next = tmp2.next;
            tmp2.next = (tmp.next != null) ? tmp.next.next : null;
            tmp = tmp.next;
            tmp2 = tmp2.next;
        }
        return ans;

    }
}