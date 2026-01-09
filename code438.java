// 用字符数量来判断是否是子串
// 用滑动窗口的数组来判断是不是子串
// 原来可以直接用Arrays.equals来比较


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<Integer>();

        int[] pnum = new int[26];
        int[] snum = new int[26];
        int n = s.length();
        int k = p.length();

        if (k > n) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            pnum[p.charAt(i)-'a']++;
            snum[s.charAt(i)-'a']++;
        }

        int left = 0;
        int right = left + k -1;


        while (right < n) {

            // 如果找到了
            if (check(pnum, snum)) {
                res.add(left);
            }

            snum[s.charAt(left)-'a']--;
            left++;
            right++;
            if (right == n) {
                break;
            }
            snum[s.charAt(right)-'a']++;

        }

        return res;



    }

    private boolean check(int[] p, int[] s) {

        boolean res = true;

        for (int i = 0; i < 26; i++) {

            if (p[i] != s[i]) {
                res = false;
                break;
            }
        }
        return res;
    }


}


// 在上面方法的基础上修改，用变量差值来快速判断省去equal过程

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<Integer>();

        int[] diff = new int[26];
        int n = s.length();
        int k = p.length();
        int ans = 0;

        if (k > n) {
            return res;
        }

        // 正数代表p串字母多，负数代表s串字母多
        for (int i = 0; i < k; i++) {
            diff[p.charAt(i) - 'a']++;
            diff[s.charAt(i) - 'a']--;
        }

        int left = 0;
        int right = left + k -1;

        for (int i = 0; i < 26; i++) {
            if (diff[i] != 0) {
                ans++;
            }
        }
        // ans代表了相差字母数量
        while (right < n) {

            // 如果找到了
            if (ans == 0) {
                res.add(left);
            }

            if (diff[s.charAt(left)-'a'] == -1) {
                ans--;
            } 

            if (diff[s.charAt(left)-'a'] == 0) {
                ans++;
            } 
            diff[s.charAt(left)-'a']++;
            left++;
            right++;


            if (right == n) {
                break;
            }
            if (diff[s.charAt(right)-'a'] == 1) {
                ans--;
            } 

            if (diff[s.charAt(right)-'a'] == 0) {
                ans++;
            } 
            diff[s.charAt(right)-'a']--;


        }

        return res;



    }

}