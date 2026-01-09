// 用双指针，核心思想：木桶短板效应，最外层的最大容量总是取决于比较
// 短的那块木板。移动的时候移动短的那块木板才有可能有新的上限。

class Solution {
    public int maxArea(int[] height) {
        

        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {

            int tmp = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, tmp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
    return res;

    }
}