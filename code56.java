class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int [0][2];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> merged = new ArrayList<int []>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 如果不合并
            if (intervals[i][0] > merged.get(merged.size() - 1)[1]) {
                merged.add(intervals[i]);
            } else {
                merged.get(merged.size() - 1)[1] = 
                Math.max(intervals[i][1], merged.get(merged.size() - 1)[1]);
            }



        }
        return merged.toArray(new int [merged.size()][]);
    }
}