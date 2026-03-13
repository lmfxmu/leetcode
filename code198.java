// 依旧动态规划,用变量可以替代数组存储信息，以为自己会写结果
// 还是错了
class Solution {
    public int rob(int[] nums) {
        int tmp1 = 0;
        int tmp2 = 0;
        int n = nums.length;
        int ans = 0;
        // 存储
        for (int i = 0; i < n; i++) {
            // 不偷和偷状态交换
            ans = Math.max(tmp1 + nums[i], tmp2);
            tmp1 = tmp2;
            tmp2 = ans;
        }
        return ans;
    }
}