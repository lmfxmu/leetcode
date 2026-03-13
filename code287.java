// 其他方法都懒得看了，后悔前99题没有直接背答案了，只背一种得了
// 快慢指针
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int head = 0;
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return slow;
    }
}