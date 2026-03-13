// 用数组做，因为是线性关联的，所以也可以不用数组用单个元素滚动
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fmax = new int[n];
        int[] fmin = new int[n];
        fmax[0] = nums[0];
        fmin[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];
            fmax[i] = Math.max(Math.max(fmin[i - 1] * x, fmax[i - 1] * x), x);
            fmin[i] = Math.min(Math.min(fmin[i - 1] * x, fmax[i - 1] * x), x);
            ans = Math.max(fmax[i], ans);
        }
        return ans;


    }
}