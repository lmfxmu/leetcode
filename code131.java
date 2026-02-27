// 回溯法通用模板，选与不选以及枚举，这题可以用动态规划
// 枚举,这一题枚举会更好

class Solution {
    public List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(new ArrayList<>(), s, 0);
        return ans;
    }
    public void dfs (List<String> path, String s, int start) {
        int n = s.length();
        if (start == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 枚举
        for (int i = start; i < n; i++) {
            if (isValid(s, start, i)) {
                path.add(s.substring(start, i + 1));
                dfs(path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }

    }

    public boolean isValid (String s, int i, int j) {

        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    } 
}





// 提前对回文进行预处理，用空间换时间
class Solution {
    private  List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(path, s, 0, 0);
        return ans;

    }
    // 选与不选，最后一个必选，每次先检查最后一个是不是回文的，然后当前index选或不选
    private void dfs (List<String> path, String s, int start, int index) {
        // 末尾检查
        
        if (index == s.length()) {
            // 子串操作
            if (start == index) {
                return;
            }
            String tmp = s.substring(start, index);
            if (isValid(tmp)) {
                path.add(tmp);
                // 注意！所有共享状态进函数什么样出去就得是什么样
                // ，这里忘记移除，错了
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            // 注意！答案也要return
            return;
        }
        
        // 不选
        dfs(path, s, start, index + 1);

        // 选
        String tmp = s.substring(start, index + 1);
        if (isValid(tmp)) {
            path.add(tmp);
            dfs(path, s, index + 1, index + 1);
            // 复原
            path.remove(path.size() - 1);
        }
        

    }


    private boolean isValid (String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}