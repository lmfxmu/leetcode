// 中心拓展法,奇偶回文串可以合并也可以分开
// 动态规划太复杂，Manacher 算法太难，算了
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = 0;
        int ansL = 0;
        int ansR = 0;
        for (int i = 0; i <= 2 * (n - 1); i++) {
            int left = i / 2;
            int right = (i + 1) / 2;
            while (left >= 0 && right < n) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (ans < right - left + 1) {
                        ans = right - left + 1;
                        ansL = left;
                        ansR = right;
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        return s.substring(ansL, ansR + 1);
    }
}