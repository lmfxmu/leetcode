// 1.常规栈消除写法，记录最大值
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        // 栈要存储最左（的信息
        Deque<Integer> stack = new LinkedList<>();
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        // 栈顶边界
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                    ans = Math.max(ans, i - stack.peek());
                } else {
                    stack.pop();
                    stack.push(i);
                }
            }

        }
        return ans;
    }
}


// 2.更快的解法，顺逆序各遍历一遍记录最大值，逻辑要注意
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
                // 注意left>right的时候可能是非法的
                if (right == left) {
                    ans = Math.max(ans, right * 2);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }
        }

        left = 0;
        right = 0;
        // 注意下面这个逻辑还是跟上面有一些区别
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                left++;
            } else {
                right++;
                if (right == left) {
                    ans = Math.max(ans, right * 2);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }
        }
        return ans;
    }
}