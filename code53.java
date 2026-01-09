// 前缀和
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int min = 0;
        // int[] sum[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (ans < sum - min) {
                ans = sum - min;
            }
            // 维护前面前缀和的最小值
            if (min > sum) {
                min = sum;
            }
        }
        return ans;

    }
}


// 动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int ans = sum[0];
        for (int i = 1; i < nums.length; i++) {

            sum[i] = Math.max(nums[i] + sum [i - 1], nums[i]);
            ans = Math.max(ans, sum[i]);
        }
        return ans;

    }
}