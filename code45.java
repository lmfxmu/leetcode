// 贪心算法，在达到局部最远前步骤都不变。
// 还有一种一直遍历查找能到达位置的最后一个位置
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int curRight = 0;
        int maxRight = 0;
        for (int i = 0; i < n - 1; i++) {
            maxRight = Math.max(maxRight, i + nums[i]);
            if (i == curRight) {
                curRight = maxRight;
                ans++;
            }
        }
        return ans;



    }
}