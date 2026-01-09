// 使用双指针，排序之后可以转变成一个双数之和问题，左右指针从首尾移动

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    left++;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                } else {
                    if (nums[left] + nums[right] < -nums[i]) {
                        left++;
                        while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                        }
                    } else {
                        right--;
                        while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                        }
                    }
                }
            }
            // System.out.println(res);


        }

        return res;

    }
}