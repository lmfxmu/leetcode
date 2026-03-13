class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int target = nums[0];
        int number = 1;
        for (int i = 1; i < n; i++) {
            if (target != nums[i]) {
                number--;
                if (number == 0) {
                    target = nums[i];
                    number = 1;
                }
            } else {
                number++;
            }
        }
        return target;
    }
}