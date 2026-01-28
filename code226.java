// ตÝน้
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}