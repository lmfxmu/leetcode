class Solution {

    Map<Character, Integer> tar = new HashMap<Character, Integer>();
    Map<Character, Integer> now = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        
        int tlen = t.length();
        int slen = s.length();
        if (slen < tLen) {
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
        int r = tlen - 1;
        int ansL = -1;
        int ansR = -1;
        int res = 100001;

        while (r < sLen) {

            // 不符合窗口
            if (check && r < sLen - 1) {
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
                l++;
                if (l < r) {
                    char c2 = s.charAt(l);
                    tar.put(c2, now.getOrDefault(c2, 0) - 1);
                }
                


            }

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



// 优化思路：去掉无用字符引入索引相减最小值




class Solution {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry entry = (Map.Entry) iter.next(); 
            Character key = (Character) entry.getKey(); 
            Integer val = (Integer) entry.getValue(); 
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }
}
