// 自己想只能想到一半，重点是如何简化操作。还是通过贪心算法
// 来计算，最后遍历每一个字符看有没有到达目前这个小区间所有
// 字符的最边际来划分区间。算是合并区间的题目。
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] maxR = new int[26];
        Arrays.fill(maxR, 0);
        for (int i = 0; i < n; i++) {
            // 把当前字符的下标传进去当做最后一次出现
            maxR[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int right = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            // right是当前区间所有字符的最右边界
            right = Math.max(right, maxR[s.charAt(i) - 'a']);
            tmp++;
            if (i == right) {
                ans.add(tmp);
                tmp = 0;
            }
        }
        return ans;
    }
}