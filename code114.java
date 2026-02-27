// 头插法，用跟先序遍历相反的方向来写，重点记

class Solution {
    public TreeNode pre;
    public void flatten(TreeNode root) {
        pre = null;
        dfs(root);

    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return ;
        }
        // 右
        dfs(root.right);
        // 左
        dfs(root.left);
        // 根
        root.right = pre;
        root.left = null;
        pre = root;

    }
}

// 分治法，有点记不太清楚，逻辑还是需要好好理一下

class Solution {
    public void flatten(TreeNode root) {

        dfs(root);

    }
    // 把右子树放到左子树尾，返回尾节点
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 左子树的根节点
        TreeNode left = dfs(root.left);
        // 右子树的根节点
        TreeNode right = dfs(root.right);
        
        // 根节点操作
        if (left == null && right == null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        }
        // 左子树不为空
        left.right = root.right;
        root.right = root.left;
        root.left = null;
        if (right == null) {
            return left;
        }
        return right;

    }
}