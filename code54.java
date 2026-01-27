// 标记，除了外置数组也可以更改数组元素为最大值的形式
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<Integer>();
        boolean[][] visited = new boolean[m][n];
        int[][] dire = {{0, 1} , {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        int di = 0;
        for (int count = 0; count < m * n; count++) {
            ans.add(matrix[row][col]);
            visited[row][col] = true;
            int nextrow = row + dire[di][0];
            int nextcol = col + dire[di][1];
            if (nextrow >= m || nextrow < 0 || nextcol >= n || nextcol < 0) {
                di = ++di % 4;
            } else if (visited[nextrow][nextcol]) {
                di = ++di % 4;
            }
            row += dire[di][0];
            col += dire[di][1];
            
        }

        return ans;

    }
}


// 模拟  注意起点最好在圈外，这样走的步数和元素个数才符合
// 写法特别高明且难懂，数学逻辑需要盘的很清楚，实际上写的时候可以写成局部四个循环的形式更加易懂
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<Integer>();
        int count = m * n;
        
        int[][] dire = {{0, 1} , {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = -1;
        int di = 0;
        
        while (ans.size() < count) {
            for (int i = 0; i < n; i++) {
                row += dire[di][0];
                col += dire[di][1];
                ans.add(matrix[row][col]);
            }
            di = ++di % 4;
            m--;
            // 减少步数
            int tmp = m;
            m = n;
            n = tmp;
        }

       
        return ans;

    }
}