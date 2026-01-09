import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution ans = new Solution();
        ans.maxSubArray(nums);
        // System.out.println(s.groupAnagrams(strs));
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int ans = sum[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i] + sum [i - 1], nums[i]);
            ans = Math.max(ans, sum[i]);
        }
        System.out.println(Arrays.toString(sum));
        return sum[nums.length - 1];

    }
}