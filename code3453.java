// 第一次只能想到浮点二分，首先可以肯定的是关于面积的计算肯定需要优化
// 其他题解有的非常巧妙，比如利用题目信息从浮点二分变成整数二分
// 还有使用差分+扫描线的方法，不过有一个很巧妙的是首先找到某个区域变换
// 区间，答案必在其中那就可以直接算出来了。


// 介于时间，只写了浮点二分，并且面积算错了，回头再写
class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        // double totalSize = 0;
        // for (int i = 0; i < n; i++) {
        //     totalSize += Math.pow(squares[i][2]);
        // }
        // double current = 0;
        double bottom = 0;
        double top = squares[n - 1][1];
        double mid = (bottom + top) / 2;
        
        while (check(mid, squares) > 0.00001) {
            if (check(mid, squares) < 0.0) {
                bottom = mid;
            } else {
                top = mid;
            }
            mid = (bottom + top) / 2;
        }
        return mid;

    }
    public double check (double target, int[][] squares) {
        double sum = 0;
        for (int i = 0; i < squares.length; i++) {
            double tmp = (squares[i][2]) * Math.min(Math.abs(target - squares[i][1]), (squares[i][2]));
            sum += tmp * (target > squares[i][1] ? 1 : -1);
        }
        return sum; 
    }
}