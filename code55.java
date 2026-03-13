// Ì°ĞÄËã·¨
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i <= right && i < n; i++) {
            right = Math.max(right, i + nums[i]);
        }
        if (right >= n - 1) {
            return true;
        }
        return false;
    }
}