// 1.dfs 选与不选
class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(0, target, candidates, 0, path);
        return ans;
    }

    public void dfs(int sum, int target, int[] candidates, int index, List<Integer> path) {
        if (sum == target) {
            ans.add(new ArrayList(path));
            return;
        }
        if (sum > target || index >= candidates.length) {
            return;
        }
        // 选
        path.add(candidates[index]);
        dfs(sum + candidates[index], target, candidates, index, path);
        path.remove(path.size() - 1);
        // 不选
        dfs(sum, target, candidates, index + 1, path);
    }
}

// 2.枚举，从后续范围中取一个数，跟上题比较像，先不写


// 3.用完全背包来预处理减枝，注意是倒着递归，因为完全背包的信息是正着来的
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        boolean[][] f = new boolean[n + 1][target + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i - 1][j] || j >= candidates[i - 1] && f[i][j - candidates[i - 1]];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(f, ans, path, candidates, target, n - 1);
        return ans;
    }
    public void dfs(boolean[][] f, List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }
        // 注意完全背包的下标跟数组的下标是不一样的
        if (target < 0 || !f[index + 1][target])
        {
            return;
        }
        // 选
        path.add(candidates[index]);
        dfs(f, ans, path, candidates, target - candidates[index], index);
        path.remove(path.size() - 1);
        // 不选
        dfs(f, ans, path, candidates, target, index - 1);

    }
}