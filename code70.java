// .....动态规划我都忘了
class Solution {
    public int climbStairs(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        if (n > 1) {
            ans[1] = 2;
        }
        
        for (int i = 2; i < n; i++) {
            ans[i] = ans[i - 2] + ans[i - 1];
        }
        return ans[n - 1];

    }
}