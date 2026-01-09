import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        Solution ans = new Solution();
        ans.maxSlidingWindow(nums, 5);
        // System.out.println(s.groupAnagrams(strs));
    }
}


class Solution {

    Map<Character, Integer> tar = new HashMap<Character, Integer>();
    Map<Character, Integer> now = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen) {
            return "";
        }

        for (int i = 0; i < tLen; i++) {
            char c1 = t.charAt(i);
            // 标准的放字符到哈希表
            tar.put(c1, tar.getOrDefault(c1, 0) + 1);
            char c2 = s.charAt(i);
            tar.put(c2, now.getOrDefault(c2, 0) + 1);
        }


        int l = 0;
        int r = tLen - 1;
        int ansL = -1;
        int ansR = -1;
        int res = 100001;

        while (r < sLen && l < sLen - tLen) {

            // 不符合窗口
            if (check() && r < sLen - 1) {
                r++;
                char c2 = s.charAt(r);
                tar.put(c2, now.getOrDefault(c2, 0) + 1);


            } else {  
                // 符合窗口

                if (r - l + 1 < res) {
                    ansL = l;
                    ansR = r;
                    res = r - l + 1;
                }
                char c2 = s.charAt(l);
                tar.put(c2, now.getOrDefault(c2, 0) - 1);
                l++;
                

            }

        }
        if (res == 100001) {
            return "";
        } else {
            return s.substring(ansL,ansR);
        }

    }

    // 下面这一段第一次写的时候完全不会写，然后ai生成了一个看得懂的版本
    public boolean check() {
        for (Map.Entry<Character, Integer> entry : tar.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (now.getOrDefault(key, 0) < val) {
                return false;
            }
        
        }
        return true;
    }

}