// left用大顶堆  right用小顶堆
class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((i, j) -> j - i);
        right = new PriorityQueue<>();
    }
    
    // 实际上这里的逻辑还可以简化
    public void addNum(int num) {
        int m = left.size();
        int n = right.size();
        // 如果左侧跟右边一样大，移动一个数字放进left
        if (m == 0) {
            left.offer(num);
            return;
        }
        if (m == n) {
        
            if (left.peek() < num) {
                right.offer(num);
                left.offer(right.poll());
            } else {
                left.offer(num);
            }
        } else {
            // 如果左边多，那么移动一个数字放到右边
            if (left.peek() < num) {
                right.offer(num);
            } else {
                left.offer(num);
                right.offer(left.poll());
            }
        }
    } 
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return ((double) left.peek() + (double) right.peek()) / 2;
        } else {
            return (double) left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */