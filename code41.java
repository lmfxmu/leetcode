// 制作哈希数组，用位置来确定哈希值

class Solution {
    public int firstMissingPositive(int[] nums) { 
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(nums[i]);
            // 可能存在两个同样的数字，需要避免两次取反操作。
            if (tmp != n + 1) {
                nums[tmp - 1] =  -Math.abs(nums[tmp - 1]);
            }
        }
        int ans = 0;
        while (ans < n) {
            if (nums[ans] >= 0) {
                break;
            }
            ans++;
        }
        return ans+1;
    }
}

// 置换
class Solution {
    public int firstMissingPositive(int[] nums) { 
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            // 可能存在两个同样的数字，需要避免一直交换
            if (nums[i] != n + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            }
            
        }

        int ans = 0;
        while (ans < n) {
            if (nums[ans] != ans + 1) {
                break;
            }
            ans++;
        }
        return ans+1;
    }
}
