// 就是要把访问过的节点标为1的深搜
class Solution {
    public int m;
    public int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    // 把访问过的岛屿标记
    public void dfs(char[][] grid, int row, int col) {

        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}