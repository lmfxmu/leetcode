// 这一题也是完全不会。核心就在于答案可以通过枚举矩形的高或者宽来
// 实现，这一题用枚举高比较合适，找到某一个柱子左右侧最远的等高柱子，
// 然后计算答案寻找最大值。实际写的时候可以多遍历几次，为了学习这里
// 就用优化过后的三次便利，二次遍历，一次遍历来写。
// 递增栈用来存储，这类不能用递减，主要要考虑后续信息到底有没有用，
// 这一题如果是递减的，那左边曾经的最低已经被退栈了，后面找不到这个邻近
// 的最低。如果是递增的话确保了能找到最远的比自己高的元素。
// 核心记忆口诀
// 找下一个更小的数（比如求面积限制）：用递增栈（把大的踢走，留下小的）。

// 找下一个更大的数（比如每日温度）：用递减栈（把小的踢走，留下大的）。

// 三次遍历
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        
        // 递增栈,找到左侧第一个小的元素。
        // stack.push(-1);
        for (int i = 0; i < n; i++) {
            // 退出递增栈中所有大于等于自身的元素
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        // stack.push(n);
        // 栈空的时候代表是边界
        for (int i = n - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
        }
        return ans;

    }
}


// 两次遍历
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n - 1);
        int ans = 0;
        
        // 递增栈,找到左侧第一个小的元素。
        // stack.push(-1);
        for (int i = 0; i < n; i++) {
            // 退出递增栈中所有大于等于自身的元素
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                // 栈顶右侧第一个小元素就是当前的i
                right[stack.pop()] = i - 1;
                
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
        }
        return ans;

    }
}


// 一次遍历，涉及left和right，直接在right出栈时计算答案
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        
        // 递增栈,找到左侧第一个小的元素。
        stack.push(-1);
        for (int i = 0; i <= n; i++) {
            // 退出递增栈中所有大于等于自身的元素
            int tmpH = i == n ? 0 : heights[i];
            while (stack.size() > 1 && tmpH <= heights[stack.peek()]) {
                // 当前元素是栈顶的右边第一小元素
                right = i - 1;
                int tmp = stack.pop();
                left = stack.peek() + 1;
                // 计算答案
                ans = Math.max(ans, (right - left + 1) * heights[tmp]);
                
            }
            stack.push(i);
        }
        
        
        return ans;

    }
}