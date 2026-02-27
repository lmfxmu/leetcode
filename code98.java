/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//  递归返回boolean值,注意数值的范围是long
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean dfs(TreeNode root, long min, long max) {
        
        if (root == null) {
            return true;
        }

        int cur = root.val;
        if (cur <= min || cur >= max) {
            return false;
        }
        // 左节点
        return dfs(root.left, min, cur) && dfs(root.right, cur, max);
        // 

    }
}


// 中序遍历，利用二叉搜索树的特性是递增的
class Solution {
    public long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        if (isValidBST(root.left) == false) {
            return false;
        }
        // 中
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;

        // 右
        if (isValidBST(root.right) == false) {
            return false;
        }
        return true;

    }
}


// 后序遍历，需要用数组来记录字数的范围，感觉没必要掌握，不写了