// 按照题意的状态转移方程写
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmpTmp = new ArrayList<>();
        tmpTmp.add(1);
        ans.add(tmpTmp);
 
        for (int i = 2; i <= numRows; i++) {
            // 开头加1
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            int n = ans.size();
            // 要加的个数i - 2
            for (int j = 1; j < i - 1; j++) {
                tmp.add(ans.get(n - 1).get(j - 1) + ans.get(n - 1).get(j));
            }
            tmp.add(1);
            ans.add(tmp);
        }
        return ans;
    }
}