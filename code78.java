// 每一个元素进行进入dfs,选择或者不选
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return ans;

    }
    private void dfs(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        // 不加入
        dfs(nums, index + 1, path);

        // 加入
        path.add(nums[index]);
        dfs(nums, index + 1, path);
        path.remove(path.size() - 1);
    }
}


// 选择一个数字,然后只从后面的数字开始挑选(其实也是深搜选择或者不选)
class Solution {
    public List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return ans;

    }
    
    private void dfs (int[] nums, int index, List<Integer> path) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 注意,还有一个不选,直接把当前的加进去,容易忘
        ans.add(new ArrayList<>(path));
        // 至少选一个
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}


// 二进制枚举,注意位运算运算的方式
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> path = new ArrayList<>();
        int n = nums.length;
        // 注意,有2^n种方式,因此不是n,而是1 << n
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j< n; j++) {
                if ((i >> j & 1) == 1) {
                    path.add(nums[j]);
                }
            }
            ans.add(path);
        }
        return ans;
    }
}