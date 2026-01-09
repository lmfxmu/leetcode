class Solution {
    public int[] twoSum(int[] nums, int target) {
    // 先创建哈希表，然后存入前面已经存在的值，不用遍历而是
    // 用哈希表去搜
        int n = nums.length;
        Map <Integer, Integer> hashtable = new HashMap <Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (hashtable.containsKey(target - nums[i]))
            {
                int tmp = hashtable.get(target - nums[i]);
                return new int[] {tmp, i};
            }
            else {
                hashtable.put(nums[i], i);
            }
        }
        return new int[0];

    }
}






















 


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

