// dfs
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

// bfs
class Solution {
    public int maxDepth(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        if (root == null) {
            return 0;
        }


        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                size--;
            }
            ans++;
        }
        return ans;

    }
}