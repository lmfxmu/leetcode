//  这题跟之前的有点像，也是搞懂算法逻辑就行，第一次也没想出来。
//  总结就是用左链+右链， 维护最大值，之前没想出来是老是想返回
//  某个值，但实际上用不到下面的信息，直接维护答案就行了
class Solution {
    public int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获得左右链,(链为空值为0，可以一起算)
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        // 拼装起来
        int tmp = leftSum + root.val + rightSum;
        // 维护答案
        ans = Math.max(ans, tmp);
        // 返回值只能返回作为链的最大值
        tmp = Math.max(leftSum + root.val, rightSum + root.val);
        // 如果都是负数，则当做空链
        return Math.max(tmp, 0);

    }
}