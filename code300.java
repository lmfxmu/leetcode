// 这题也难，常规动态规划复杂度为On2
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 注意要保存结果最大值，因为dp代表的是以最后一个结尾的值
        int ans = 1;
        int[] dp = new int[n + 1];
        // 下面这个填充也是有逻辑的，注意dp一定要设置好初始值
        Arrays.fill(dp, 1);
        dp[0] = 0;
        // i代表以第i个字符结尾的最长子序列值
        for (int i = 1; i <= n; i++) {
            // 从前j个的答案里选一个最大的
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

// 要用到Onlogn一般就是二分，归并，感觉有点难了
// 设计一个特殊的数组,tail维护长度为k的尾部元素，tail也是递增的
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int ans = 0;
        // 用二分找到应该插入的地方
        for (int num : nums) {
            int left = 0;
            int right = ans;
            while (left < right) {
                int mid = (left + right) / 2;
                if (num > tail[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 找到的left不用比较直接替换
            tail[left] = num;
            if (left == ans) {
                ans++;
            }
        }
        return ans;

    }
}