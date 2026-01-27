// 找到规律，[i, j] 顺时针旋转后-> [j, n - 1 - i]
// 第一种方法，一次选转四个相应的位置，遍历特定区域应该旋转的位置
// 虽然是顺时针旋转，但是节点赋值却是逆时针的，这一点推了一段时间
// 至于旋转的元素区域，题解用的是矩形，我用的是对角线区域，需要注意的是
// 必须要使用类似左闭右开的区间，不然会重复
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; n - 2 * i > 0; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
                
            }
        }
    }
}



// 推导出数学公式后，即可使用单个元素转换的数学推导，即先对角线转置再水平翻转
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0 ; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][n - 1 -j];
                matrix[i][n - 1 -j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
