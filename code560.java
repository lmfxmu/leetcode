// 前缀和，使用哈希表记录出现的前缀和次数

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        int n = nums.length;

        int tmp = 0;
        int res = 0;
        // 连续数组
        hashtable.put(0, 1);

        for (int i = 0; i < n; i++) {

            tmp += nums[i];
            // 如果有答案
            if (hashtable.containsKey(tmp - k)) {
                res += hashtable.get(tmp - k);
            }

            // 入表
            hashtable.put(tmp, hashtable.getOrDefault(tmp, 0) + 1);

        }
        return res;


    }
}