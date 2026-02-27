// 注意一下字符串是怎么使用的，Stringbuffer String char[]之间的关系
class Solution {
    private String[] map;
    private List<String> ans;
    public List<String> letterCombinations(String digits) {
        map = new String[]{
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        ans = new ArrayList<>();
        char[] path = new char[digits.length()];
        dfs(0, path, digits);
        return ans;

    }
    public void dfs(int index, char[] path, String digits) {
        if(index == digits.length()) {
            ans.add(new String(path));
            return;
        }
        // digits.charAt(index): 输入的数字字符串第index个字符
        int place = digits.charAt(index) - '2';
        for (int i = 0; i < map[place].length(); i++) {
            path[index] = map[place].charAt(i);
            dfs(index + 1, path, digits);
        }

    }
}