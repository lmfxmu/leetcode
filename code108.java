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
//  常规递归
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        // 左节点
        TreeNode root = new TreeNode(nums[mid]);
        // 右节点
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

}

