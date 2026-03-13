// 算法复杂度必须要是O（n）的话，就必须要用快排来写，每次只选择一个区间
// 方便一点的话就不要上下标，直接用空间换时间
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        List<Integer> numAll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numAll.add(nums[i]);
        }
        int ans = quickSort(numAll, k);
        return ans;
         
    }
    public int quickSort(List<Integer> numAll, int k) {

        List<Integer> numBig = new ArrayList<>();
        List<Integer> numSmall = new ArrayList<>();
        List<Integer> numSame = new ArrayList<>();
        // 理论上要随机取一个，这一题本身就是随机的，但为了记忆
        // 还是随机取一下，注意生成的随机数是开区间，常规要+1。
        // 常规使用Random的nextINt
        int n = numAll.size();
        int randowInt = numAll.get((int) (Math.random() * n));
        for (int tmp : numAll) {
            if (tmp > randowInt) {
                numBig.add(tmp);
            } else if (tmp < randowInt) {
                numSmall.add(tmp);
            } else {
                numSame.add(tmp);
            }
        }

        if (numBig.size() >= k) {
            return quickSort(numBig, k);
        }
       
        if (numSmall.size() > n - k) {
            return quickSort(numSmall, numSmall.size() - n + k);
        }

        return numSame.get(0);
    }
}