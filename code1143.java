// 动态规划,一维的暂时没写出来，先写二维，这题逻辑没想懂
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        // i代表执行到text1前i个字符，j代表的是text2前j个字符的公共子序列
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text2.charAt(j - 1) == text1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
}


// 一维
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        // i代表执行到text1前i个字符，j代表的是text2前j个字符的公共子序列
        
        for (int i = 1; i <= m; i++) {
            // 搞不太懂这个pre的用意
            int pre = 0;
            for (int j = 1; j <= n; j++) {
                // 这个要记忆的不好写，乖乖二维把
                int tmp = dp[j];
                if (text2.charAt(j - 1) == text1.charAt(i - 1)) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = tmp;

            }
        }
        
        return dp[n];
    }
}