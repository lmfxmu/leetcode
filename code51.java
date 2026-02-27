// 本质上应该意识到这是一个列号或者行号的全排列问题，然后记住
// 一下斜线怎么快速判断是否是同一斜线即检查行号±列号，可以用
// 数组或者哈希表来快速检索

class Solution {
    public List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] path = new int[n];
        boolean[] col = new boolean[n];
        boolean[] xie1 = new boolean[2 * n + 1];
        boolean[] xie2 = new boolean[2 * n + 1];
        dfs(path, col, xie1, xie2, n, 0);
        return ans;


    }

    public void dfs (int[] path, boolean[] col, boolean[] xie1, boolean[] xie2, int n, int index) {
        if (index == n) {
            List<String> tmp = new ArrayList<>();
            char[] tmp2 = new char[n];
            Arrays.fill(tmp2, '.');
            for (int i = 0; i < n; i++) {
                tmp2[path[i]] = 'Q';
                tmp.add(new String(tmp2));
                tmp2[path[i]] = '.';
            }
            ans.add(new ArrayList(tmp));
            return;

        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !xie1[index - i + n] && !xie2[index + i]) {
                path[index] = i;
                col[i] = true;
                xie1[index - i + n] = true;
                xie2[index + i] = true;
                dfs(path, col, xie1, xie2, n, index + 1);
                col[i] = false;
                xie1[index - i + n] = false;
                xie2[index + i] = false;
            }
        }

    }

}