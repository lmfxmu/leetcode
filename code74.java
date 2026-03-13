// 两种二分,一种先列后行,一种排成一行二分
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m - 1;
        // 想了很久,还是太依赖模板了,需要自己多思考一些,这一题明显
        // 不能用常规模版,mid要取上不然的话左区间会无法确定,而且low
        // ==high的时候就说明找到需要退出了
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (matrix[low][mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (matrix[low][left] == target) {
            return true;
        }
        return false;
        


    }
}