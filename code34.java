// 二分查找修改mid找最开头和最结尾
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ansleft = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果<,说明在右边
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 如果=,说明在当前位置或左边
                right = mid;
            }
        }
        // 记住特殊返回
        if (n == 0 || nums[left] != target) {
            return new int[]{-1, -1};
        }
        ansleft = left;
        left = 0;
        right = n - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 如果<=,说明在当前位置或者右边
            if (nums[mid] <= target) {
                left = mid;
            } else {
                // 如果>,说明在左边
                right = mid - 1;
            }
        }
        return new int[]{ansleft, left};

    }
}