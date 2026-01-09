// 双指针  左指针之前指向排序好的  右指针始终指向第一个要排序的数
// 中间都是0，这一点困扰了我很久
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                // 找到了要交换的非0数
                swap(left, right, nums);
                left++;
            }
            right++;
        }

    }

    public static void swap (int left, int right, int[] nums) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;

    }
}