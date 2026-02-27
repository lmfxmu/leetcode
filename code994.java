// 这题也不咋会，这题应该用bfs，思路是简单的，但是写起来
// 比较繁琐，有很多小细节需要注意。
class Solution {
    public int orangesRotting(int[][] grid) {
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        Deque<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int time = 0;
        while (!q.isEmpty()) {
            int tmpSize = q.size();
            while (tmpSize > 0) {
                int[] tmp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int tmpRow = tmp[0] + row[i];
                    int tmpCol = tmp[1] + col[i];
                    if (tmpRow >= 0 && tmpRow < m && tmpCol >= 0 && tmpCol < n) {
                        if (grid[tmpRow][tmpCol] == 1) {
                            grid[tmpRow][tmpCol] = 2;
                            fresh--;
                            
                            q.offer(new int[]{tmpRow, tmpCol});
                        }
                    }
                }
                tmpSize--;
            }
            time++;
            if (fresh == 0) {
                break;
            }
        }

        if (fresh > 0) {
            return -1;
        }
        return time;
    }
    
}