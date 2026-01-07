// 动态规划，算出每个坐标的左右最大高度单独计算容量（竖着累加）

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Math.min(left[i], right[i]) - height[i];
            if (tmp < 0) {
                tmp = 0;
            }
            res += tmp;
        }

        return res;

    }
}




// 使用单调栈来维护，遇到容器时，对于每一层进行计算,横着累加
// 注意：栈中存的是下标
class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // 当遇到高低差的时候,进行结算
        int res = 0;

        for (int i = 0; i < n; i++) {

            // 要注意，需要用while来处理栈中所有的元素
            // System.out.println("stack:\t" + stack);
            // System.out.println("height[i]:\t" + height[i]);


            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // System.out.println("stack:\t" + stack);
                int right = i;
                int bottom = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                // System.out.println("l:" + left + bottom + right);

                int tmp = Math.min(height[left], height[right]);
                tmp = (tmp - height[bottom]) * (right - left - 1);
                // System.out.println("tmp:" + tmp);
                res += tmp;
                // System.out.println("res:\t" + res);

                
            }
            // 每个元素最终都需要入栈
            stack.push(i);

        }

        return res;

    }
}







// 使用双指针来动态规划,核心思想参考接雨水最大容器短板效应
// 每次移动后就计算短板那一块的容量，因为短板的最大容量已经
// 被确定了，随后移动短板一侧的指针。

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftmax = height[0];
        int rightmax = height[n - 1];
        int res = 0;
        int left = 1;
        int right = n - 1;
        while ( left <= right) {

            if (leftmax < rightmax) {

                int tmp = Math.min(leftmax, rightmax) - height[left];
                if (tmp < 0) {
                    tmp = 0;
                }
                res += tmp;

                leftmax = Math.max(leftmax, height[left]);
                left++;
            } else {

                int tmp = Math.min(leftmax, rightmax) - height[right];
                if (tmp < 0) {
                    tmp = 0;
                }
                res += tmp;

                rightmax = Math.max(rightmax, height[right]);
                right--;
            }


        }



        return res;

    }
}
