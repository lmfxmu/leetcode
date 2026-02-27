//  层序遍历，记录size的最后一个或者第一个add
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            while (n > 0) {
                TreeNode tmp = deque.poll();
                if (n == 1) {
                    ans.add(tmp.val);
                }
                if (tmp.left != null) {
                    deque.offer(tmp.left);
                }
                if (tmp.right != null) {
                    deque.offer(tmp.right);
                }
                n--;
            }
            

        }
        return ans;
    }
}

//  很巧妙的方法，深搜，用右子树的先序遍历来找每一层的第一个节点
//  重点是处理深度的第一个节点的逻辑，通过size来记，如果是我只能想到哈希表
class Solution {
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return ;
        }


        // 第一次遇到这个深度
        if (ans.size() == depth) {
            ans.add(root.val);
        }

        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}