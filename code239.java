
// 优先队列，大根堆

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        PriorityQueue<int[]> dq = new PriorityQueue<int[]>(
            new Comparator<int[]>() {

                public int compare(int[] pair1, int[] pair2) {
                    if (pair1[0] == pair2[0]) {
                        return pair2[1] - pair1[1];
                    } else {
                        return pair2[0] - pair1[0];
                    }


                }
            } 

        );

        for (int i = 0; i < k; i++) {
            dq.offer(new int[]{nums[i], i});
        }
        res[0] = dq.peek()[0];

        for (int i = k; i < n; i++) {
            // 得先进优先队列，不然peek到null会报错
            dq.offer(new int[]{nums[i], i});
            while (i - dq.peek()[1] >= k ) {
                dq.poll();
            }
            
            
            res[i - k + 1] = dq.peek()[0];
            // System.out.println("nums:" + dq.peek()[0] + " i:" + dq.peek()[1]);
        }
        
        return res;
    }
}





// 维护一个队列，严格执行下标大于前面的成员，而值小于前面的成员策略
// 一直奇怪的点在于，怎么才能保证队列里有数，卡在这里卡了很久
// 最后才明白，不是只在队首删除，两端都有可能删除
// 比如10 3 4这个窗口的队列  会从10 3 变成10 4

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        DeQueue<Integer> dq = new ArrayDeque <Integer>();

    }
}







// 参考题解1：优先队列
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}


// 参考题解2：单调队列

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}

