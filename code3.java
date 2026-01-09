// 常规方法： 滑动窗口，用哈希表来存子串内容

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int res = 0;
        int tmp = 0;
        while (left < n && right < n) {

            // 如果没有重复的字符，入库

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                tmp++;
                res = Math.max(tmp, res);
            } else {
            // 如果最右侧是重复的字符，左指标右移直到不存在重复字符
                set.remove(s.charAt(left));
                left++;
                tmp--;
                res = Math.max(tmp, res);
            }



        }
        return res;

    }
}


