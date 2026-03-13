// 单次遍历实在太恶心了，要记技巧，然后要倒过来覆盖，
// 不然会出现数组没有2却有2的情况。还有另外两种双指针
// 写法，临近尾声，只想记一种了。
// 用三路快排的方法
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        int p2 = n - 1;
        // po左侧都已经排序好0，是最后要放0的地方
        // p1-p2是还没有遍历过的地方
        // p2右侧是已经排序好的2,是第一个要放2的地方
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                int tmp = nums[p1];
                nums[p1] = nums[p0];
                nums[p0] = tmp;
                p0++;
                p1++;
            } else if (nums[p1] == 1) {
                p1++;
            } else {
                int tmp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = tmp;
                p2--;
            }
        }

    }
}