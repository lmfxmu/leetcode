// 纯背套路，类似找到下一个大数
// 1.从右往左找到第一个相邻升序的数i,j
// 2.找到j右边最小即第一个“大数”，和j左边的数交换
// 3.反转j右边的数
// 若i超出范围，则直接反转
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        int left = n - 2;
        int right = n - 1;
        // 第一步
        while (left >= 0 && nums[left] >= nums[right]) {
            right--;
            left--;
        }

        if (left >= 0) {
            int k = n - 1;
            while (nums[k] <= nums[left]) {
                k--;
            }
            swap(nums, left, k);
        }

        int i = right;
        int j = n - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }


    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}