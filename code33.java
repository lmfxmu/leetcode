// 也是二分查找,但是要修改区间确认的方式,找旋转点也是同理
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果在左边有序
            if (nums[left] <= nums[mid]) {
                // 数值在该闭区间,则找左边
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {  //否则右边一定有序
                if (target <= nums[right] && target >= nums[mid]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}