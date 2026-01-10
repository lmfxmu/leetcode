class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] from = new int[n];
        int[] after = new int[n];
        int[] ans = new int[n];
        from[0] = 1;
        after[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            from[i] = from[i - 1] * nums[i - 1];
            after[n - 1 - i] = after[n - i] * nums[n - i];
        }
        System.out.println(Arrays.toString(from));
        for (int i = 0; i < n; i++) {
            ans[i] = from[i] * after[i];
        }
        return ans;
    }
}


// 额外数组记录

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] from = new int[n];
        int after = 1;
        from[0] = 1;
        for (int i = 1; i < n; i++) {
            from[i] = from[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            after *= nums[i + 1];
            from[i] = from[i] * after;
        }
        return from;
    }
}