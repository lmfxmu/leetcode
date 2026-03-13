// 哈希表记录每个元素出现次数，然后就是对这个哈希表进行操作
// ，最神的就是桶排序方面，时间复杂度只有O（n），用时间换时间
// 。然后就是堆排序，快排。

// 桶排序太难写了，后面优化一下代码
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max1 = Collections.max(map.values());
        // 用list来代替，因为可能有多个重复出现,下标代表出现次数

        List<Integer>[] buc = new ArrayList[max1 + 1];
        // 下面这个不会就用for循环一个一个加
        Arrays.setAll(buc,  i -> new ArrayList<>());
        // 记住这个迭代方式
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            buc[e.getValue()].add(e.getKey());
        }
        int count = k;
        int[] ans = new int[k];
        for (int i = max1; i >= 0 && count > 0; i--) {
            while (!buc[i].isEmpty() && count > 0) {
                ans[count - 1] = buc[i].get(buc[i].size() - 1);
                buc[i].remove(buc[i].size() - 1);
                count--;
            }
        }
        return ans;
        
    }
}


// 堆排序比较简单
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 需要好好背一下，这些函数都看不太懂
        // 也可以换小顶堆并加上一个设置最优队列大小不超过k的限制
        PriorityQueue<int[]> queue = new PriorityQueue<>((i, j) -> j[1] - i[1]);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.offer(new int[]{(int)e.getKey(), (int)e.getValue()});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;


        
    }
}