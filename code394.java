// 这一题其实主要难在字符串操作上，用辅助栈写，递归感觉更好理解
// 代码更复杂
class Solution {
    public String decodeString(String s) {
        Deque<Integer> numS = new LinkedList<>();
        Deque<String> stringS = new LinkedList<>();
        int num = 0;
        StringBuilder res = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numS.push(num);
                num = 0;
                stringS.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                int tmpNum = numS.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < tmpNum; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stringS.pop() + tmp);
                
            } else {
                res.append(c);
            }
        }
        return res.toString();

    }
}


