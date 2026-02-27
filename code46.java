// 全排列,注意list的用法,常规回溯算法
class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, false);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        dfs(0, n, now, flag, nums, ans);
        return ans;
    }
    public void dfs(int index, int n, List<Integer> now, boolean[] flag,
        int[] nums, List<List<Integer>> ans) {
        // 递归终点,加入答案
        if (index == n) {
            ans.add(new ArrayList(now));
            return;
        }
        // 尝试每一种可能
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                now.add(nums[i]);
                flag[i] = true;
                dfs(index + 1, n, now, flag, nums, ans);
                // 还原现场,注意list是怎么移除的
                now.remove(now.size() - 1);
                flag[i] = false;
            }
        }


    }
}