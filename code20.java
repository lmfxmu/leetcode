class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                deque.push(s.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != deque.peek()) {
                    return false;
                }
                deque.pop();
            }
        }
        if (deque.size() != 0) {
            return false;
        }
        return true;
    }
}