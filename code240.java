// 题解给了一个每行二分查找的方法，算是半暴力算法。
// 重点是找到矩阵的规律，刚开始一直想不到，因为如果从左上角开始的话
// 一定会面临多重选择，但如果从右上角开始的话对于两种不符情况都只有
// 一种可能来减小目标区域，本质上还是属于找数学规律的方式。


// 从最右上角开始探索的话就只有两种情况并对应唯一的选择
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

// 二分查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            if (twofind(target, matrix[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean twofind(int target,int[] num) {
        int left = 0;
        int right = num.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (num[mid] > target) {
                right = mid - 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else if (num[mid] == target) {
                return true;
            }
            mid = (left + right) / 2;
        }
        return false;
    }
}