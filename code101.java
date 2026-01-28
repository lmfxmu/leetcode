// 递归
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return ansFunc(root.left, root.right);
    }

    public boolean ansFunc(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left == null && right == null) {
                return true;
            }
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        return (ansFunc(left.right, right.left) && ansFunc(left.left, right.right));


    }
}

//  迭代，迭代不一定总是要用栈，这一题用的是题目特殊信息，
//  即左字数等于右子树，因此用队列每次对比两个节点就行
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return ansFunt(root, root);
    }

    public boolean ansFunt(TreeNode node1, TreeNode node2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node1);
        queue.offer(node2);
        while (!queue.isEmpty()) {
            TreeNode tmp1 = queue.poll();
            TreeNode tmp2 = queue.poll();
            if (tmp1 == null || tmp2 == null) {
                if (tmp1 == tmp2) {
                    continue;
                }
                else {
                    return false;
                }
            }
            if (tmp1.val != tmp2.val) {
                return false;
            }
            queue.offer(tmp1.left);
            queue.offer(tmp2.right);
            queue.offer(tmp1.right);
            queue.offer(tmp2.left);
        }
        return true;
    }
}