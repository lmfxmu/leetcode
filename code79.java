// 传统的回溯，然后可以考虑用剪枝优化，比如提前计算board和word
// 的字母数量然后提前返回false。如果单词开头字母很多那可以反转单词
// 从尾巴搜寻
class Solution {
    // private int[][] move = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
    public boolean exist(char[][] board, String word) {
        
        char[] des = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, des, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;


    }
    private boolean dfs (char[][] board, char[] des, int x, int y, int k) {
        int m = board.length;
        int n = board[0].length;
        if (k == des.length) {
            return true;
        }
        if (!isValid(m, n, x, y) || board[x][y] != des[k]) {
            return false;
        }
        char tmp = board[x][y];
        board[x][y] = '1';
        boolean ans = dfs(board, des, x, y - 1, k + 1) || dfs(board, des, x, y + 1, k + 1)
            || dfs(board, des, x - 1, y, k + 1) || dfs(board, des, x + 1, y, k + 1);
        board[x][y] = tmp;
        return ans;
    }

    private boolean isValid (int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        return true;
    }
}