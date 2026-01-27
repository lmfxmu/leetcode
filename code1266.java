// «–±»—©∑Úæ‡¿Î
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int ans = 0;
        for (int count = 0; count < points.length - 1; count++) {
            int dx = Math.abs(points[count][0] - points[count + 1][0]);
            int dy = Math.abs(points[count][1] - points[count + 1][1]);
            ans += Math.max(dx, dy);

        }
        return ans;
    }
}