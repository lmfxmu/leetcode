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
        }


        int l = 0;
        int r = 0;
        int ansL = -1;
        int ansR = -1;
        int res = 100001;

        while (r < sLen ) {

            char cright = s.charAt(r);
            now.put(cright, now.getOrDefault(cright, 0) + 1);

            
            // 符合窗口

            while (check() && l <= r) {
  
                

                if (r - l + 1 < res) {
                    ansL = l;
                    ansR = r;
                    res = r - l + 1;
                }
                char cleft = s.charAt(l);
                now.put(cleft, now.getOrDefault(cleft, 0) - 1);
                l++;
                

            }
            // 不符合窗口
            r++;

        }

        return ansL == -1 ?"" : s.substring(ansL, ansR + 1);


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



// 优化思路：用一个变量来存储check值
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
        }


        int l = 0;
        int r = 0;
        int ansL = -1;
        int ansR = -1;
        int res = 100001;
        int valid = 0;

        while (r < sLen ) {

            char cright = s.charAt(r);
            now.put(cright, now.getOrDefault(cright, 0) + 1);
            if (tar.containsKey(cright) && tar.get(cright).equals(now.get(cright))) {
                valid++;
            }
            
            // 符合窗口

            while (valid == tar.size() && l <= r) {
  
                

                if (r - l + 1 < res) {
                    ansL = l;
                    ansR = r;
                    res = r - l + 1;
                }
                char cleft = s.charAt(l);

                if (tar.containsKey(cleft) && tar.get(cleft).equals(now.get(cleft))) {
                    valid--;
                }
                now.put(cleft, now.getOrDefault(cleft, 0) - 1);
                l++;
                

            }
            // 不符合窗口
            r++;

        }

        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);


    }


}




