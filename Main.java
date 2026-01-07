import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        Solution ans = new Solution();
        ans.maxSlidingWindow(nums, 5);
        // System.out.println(s.groupAnagrams(strs));
    }
}


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
            if (i - dq.peek()[1] >= k ) {
                dq.poll();
            }
            
            dq.offer(new int[]{nums[i], i});
            res[i - k + 1] = dq.peek()[0];
            System.out.println("nums:" + dq.peek()[0] + " i:" + dq.peek()[1]);
        }
        
        return res;
    }
}

