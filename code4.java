// 纯逻辑推导，每次减掉一些元素，很难写
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        if (k % 2 == 1) {
            return (double)find(nums1, nums2, k / 2 + 1);
        } else {
            double ans = (double)find(nums1, nums2, k / 2) + (double)find(nums1, nums2, k / 2 + 1);
            return ans / 2;
        }

    }

    public int find (int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
  
        // left代表左边被排除的元素,不包括当前的位置
        int left1 = 0;
        int left2 = 0;


        while (true) {
            // 如果某个数组已经全部用完
            if (left1 == m) {
                return nums2[left2 + k - 1];
            }
            if (left2 == n) {
                return nums1[left1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]);
            }
            int removeHalf = k / 2;

            // 如果num1的前k/2个更小,排除
            if (nums1[Math.min(left1 + removeHalf - 1, m - 1)] < nums2[Math.min(left2 + removeHalf - 1, n - 1)]) {
                // left右移,如果到了末尾直接设置成m,下次就会
                // 退出,第一次写顺序搞错了
                k -= Math.min(removeHalf, m - left1 );
                left1 = Math.min(left1 + removeHalf, m);
                
            } else {
                k -= Math.min(removeHalf, n - left2);
                left2 = Math.min(left2 + removeHalf, n);
                
            }
        }
        

        
    }
}


// 用数组划分的特性来找，属于是题目特殊的处理方式，先用枚举一个一个递增，左边
// 数组的最大值小于右边数组的最小值
// 这一题用了非常长的时间来写，逻辑和思路都不好写
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int index = 0;
        while (index <= m) {
            int index2 = (m + n + 1) / 2 - index;
            int max1 = (index == 0 ? Integer.MIN_VALUE : nums1[index - 1]);
            int max2 = (index2 == 0 ? Integer.MIN_VALUE : nums2[index2 - 1]);
            int min1 = (index == m ? Integer.MAX_VALUE : nums1[index]);
            int min2 = (index2 == n ? Integer.MAX_VALUE : nums2[index2]);
            if (Math.max(max1, max2) <= Math.min(min1, min2)) {
                if ((m + n) % 2 == 1) {
                    return (double)Math.max(max1, max2);
                } else {
                    return ((double)Math.max(max1, max2) + (double)Math.min(min1, min2)) / 2;
                }
            }
            index++;
        }
        return 0.0;
    }
}


// 优化1，实际上左边数组的最大值小于右边数组的最小值可以简化为nums1右临界>=nums2左临界
// ，因为退出循环的上一轮已经实现了比较nums1左临界<=num2右临界
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int index = 0;
        while (index <= m) {
            int index2 = (m + n + 1) / 2 - index;
            int max1 = (index == 0 ? Integer.MIN_VALUE : nums1[index - 1]);
            int max2 = (index2 == 0 ? Integer.MIN_VALUE : nums2[index2 - 1]);
            int min1 = (index == m ? Integer.MAX_VALUE : nums1[index]);
            int min2 = (index2 == n ? Integer.MAX_VALUE : nums2[index2]);
            if (min1 >= max2) {
                if ((m + n) % 2 == 1) {
                    return (double)Math.max(max1, max2);
                } else {
                    return ((double)Math.max(max1, max2) + (double)Math.min(min1, min2)) / 2;
                }
            }
            index++;
        }
        return 0.0;
    }
}


// 优化2,用二分查找去替代枚举+1
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int index = 0;
        int right = m;
        while (index < right) {
            int median = (index + right) / 2;
            int index2 = (m + n + 1) / 2 - median;
            int min1 = (median == m ? Integer.MAX_VALUE : nums1[median]);
            int max2 = (index2 == 0 ? Integer.MIN_VALUE : nums2[index2 - 1]);

            if (min1 <= max2) {
                index = median + 1;
            } else {
                right = median;
            }
        }


        int index2 = (m + n + 1) / 2 - index;
        int max1 = (index == 0 ? Integer.MIN_VALUE : nums1[index - 1]);
        int max2 = (index2 == 0 ? Integer.MIN_VALUE : nums2[index2 - 1]);
        int min1 = (index == m ? Integer.MAX_VALUE : nums1[index]);
        int min2 = (index2 == n ? Integer.MAX_VALUE : nums2[index2]);
        if (min1 >= max2) {
            if ((m + n) % 2 == 1) {
                return (double)Math.max(max1, max2);
            } else {
                return ((double)Math.max(max1, max2) + (double)Math.min(min1, min2)) / 2;
            }
        }
        return 0.0;
    }
}