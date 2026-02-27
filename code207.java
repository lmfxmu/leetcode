// 这一题完全没思路，而且很多第一次见的定义写法，重点背一下
// 主要思路就是先形成有向图，然后检查有没有环

// dfs写法，简单来说就是遍历每个点的情况，然后有三种状态
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        // 0:未访问  1：在当前轮次已访问  2：此前已dfs过，安全
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<Integer>());
        }
        // 有向邻接表：先修课指向多个后修课
        for (int[] tmp : prerequisites) {
            map.get(tmp[1]).add(tmp[0]);    
        }
        Arrays.fill(flag, 0);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, flag, map)) {
                return false;
            }
        }

        return true;
        
    }

    // 返回该节点是不是能完成，即无环
    public boolean dfs(int course, int[] flag, List<List<Integer>> map) {
        // 正在访问中，有环
        // 之前一直无法理解的是明明要所有先修课都完成才能上后修课，为什么
        // 只需要判断当前节点的去向节点就可以，答案是不用在意这个，只需要
        // 专注于这个有向图有没有环就可以，跟题目的先修后修逻辑是分开的。
        if (flag[course] == 1) {
            return false;
        }
        // 已确定该节点安全
        if (flag[course] == 2) {
            return true;
        }

        if (flag[course] == 0) {
            flag[course] = 1;
            for (int i = 0; i < map.get(course).size(); i++) {
                if (!dfs(map.get(course).get(i), flag, map)) {
                    return false;
                }
            }
            flag[course] = -1;
        }
        return true;
    }
}


// 广搜的逻辑就比较符合直觉，跟深搜的不一样。广搜就是把所有入度为0的节点（先修课）
// 给修了之后，再去修后修课，然后把这些拓扑删完，看最后有没有剩下课没修。因为
// 已经限制过只有入度为0的节点（安全先修课）能进队列，因此如果有环的话，这些环
// 上的节点都无法进入队列里，队列空即可退出。
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        int[] inSize = new int[numCourses];
        Deque<Integer> queue = new LinkedList<>();
        Arrays.fill(inSize, 0);
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] tmp : prerequisites) {
            map.get(tmp[1]).add(tmp[0]);
            inSize[tmp[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inSize[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int tmpInt = queue.poll();
            for (int i : map.get(tmpInt)) {
                if (--inSize[i] == 0) {
                    queue.offer(i);
                }
                
            }

            numCourses--;
        }
        return numCourses == 0;        
    }
}