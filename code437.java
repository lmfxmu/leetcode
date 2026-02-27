//  使用前缀和来计算，这题也想了很久
class Solution {
    public int ans;
    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        // 用一个list来传递前面的前缀和，前缀和，次数
        Map<Long, Integer> s = new HashMap<>();
        // 自身先加进去,long要转换的要加L
        s.put(0L, 1);
        dfs(s, root, targetSum, 0L);
        return ans;
    }

    public void dfs(Map<Long, Integer> s, TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return ;
        }
        sum += root.val;
        // 以目前节点为终点，往前看有多少个起点
        ans += s.getOrDefault(sum - targetSum, 0);
        // 了解merge的用法
        s.merge(sum, 1, Integer::sum);
        dfs(s, root.left, targetSum, sum);
        dfs(s, root.right, targetSum, sum);
        // 记住要恢复现场
        s.merge(sum, -1, Integer::sum);
    }
}


//  需要用到两步递归，一个是以自己为起点，一个是以不以自己为起点
class Solution {
    // 自己不一定为起点，左右子树可能会起点，因此传递的target不变
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        // 以自己为起点的所有路径
        ans += dfs(root, targetSum);
        // 以左右子树某个点为起点
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    // 返回以自己为起点路径为target的个数，传递的target在缩小
    // 因此被视为是连贯的路径
    public int dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        // 以自己为终点
        if (root.val == targetSum) {
            ans++;
        }
        // 以左子树右子树为终点路径的可能
        int leftnum = dfs(root.left, targetSum - root.val);
        int rightnum = dfs(root.right, targetSum - root.val);
        return ans + leftnum + rightnum;
    }
}