// 自己只能想到暴力，且这题的暴力有更好的解法，因为数组很长，温度范围很小，
// 所以可以用温度数组从后往前看。自己想的错了，因为温度数组太少记录不完数据
// ，所以必须一边遍历温度列表一边更新next值，这样才能保证是递减的。
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] ans = new int[n];
        int[] temp = new int[101];
        Arrays.fill(temp, Integer.MAX_VALUE);
        // 逻辑改了非常多次
        for (int i = n - 1; i >= 0; i--) {
            int warmmer = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j < 101; j++) {
                // 如果后面的温度下标大于当前的下标
                if (i < temp[j]) {
                    warmmer = temp[j] < warmmer ? temp[j] : warmmer;
                }
            }
            // 实际上能简化为下面这个，因为倒序遍历一定不会出现更小的下标
            // for (int j = temperatures[i] + 1; j < 101; j++) {
            //     if (temp[j] < warmmer) {
            //         warmmer = temp[j];
            //     }
            // }

            
            // 坐标 - 当前坐标
            ans[i] = warmmer == Integer.MAX_VALUE ? 0 : warmmer - i;
            // 更新下标
            temp[temperatures[i]] = i;
        }

        return ans;

    }
}

// 单调栈，栈中只存非递增的元素，遇到大的元素连续出栈，自己想没
// 想到连续出栈。单调栈也可以从右到左
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        // 栈里存下标
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 非递增单调栈
            // 把栈里所有小于当前温度的给提取出来
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int tmp = stack.pop();
                ans[tmp] = i - tmp;
                
            }
                
            stack.push(i);
        }

        return ans;
    }
}