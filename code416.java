// 难得自己能想出来，就是01背包问题，选与不选->01背包,
// 不过还是错了一些
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int target = 0;
        
        for (int num : nums) {
            target += num;
        }
        if (target % 2 == 1 || n == 1) {
            return false;
        }
        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        // i代表从前i个中选，j代表容量
        // 如果当前容量小于nums[i - 1],则一定不选，继承
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                if (dp[j - nums[i - 1]]) {
                    dp[j] = true;
                }
            }
        }
        return dp[target];
    }
}