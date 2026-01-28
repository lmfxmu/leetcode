//  需要记一下直径是怎么计算的
class Solution {
    public int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        ans = Math.max(ans, leftDepth+ rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}