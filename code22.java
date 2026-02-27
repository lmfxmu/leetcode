// 记录左括号数和右括号数，每次进行选或不选，右括号数不能少于左括号数
// 注意字符串的用法
// 1.选或不选
class Solution {
    public List<String> generateParenthesis(int n) {
        char[] path = new char[2 * n];
        List<String> ans = new ArrayList<>();
        dfs(ans, path, n, 0, 0, 0);
        return ans;
    }

    public void dfs(List<String> ans, char[] path, int n, int left, int right, int index) {
        if (index ==  2 * n) {
            ans.add(new String(path));
            return;
        }
        // 选（
        if (left < n) {
            path[index] = '(';
            dfs(ans, path, n, left + 1, right, index + 1);
        }
        
        // 不选
        if (left > right) {
            path[index] = ')';
            dfs(ans, path, n, left, right + 1, index + 1);
        }
    }
}


// 2.枚举感觉很麻烦，算了