// 这一题挺难的，还要用到字符串操作
// 假设i为前面i个字符能否拆分，枚举分割点下标j,逻辑不好搞懂
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.size();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}