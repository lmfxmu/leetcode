// 先存进哈希表里节省查找时间
// 关键在于算法，如果没有比自己数字更大（小）的，说明到头了，要结算
// 如果有比自己数字更大（小）的，则跳过

class Solution {
    public int longestConsecutive(int[] nums) {

    }
}



















// 题解

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
