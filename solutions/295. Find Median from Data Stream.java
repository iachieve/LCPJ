class MedianFinder {
​
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // heap is a minimal heap by default
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // change to a maximum heap
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) return (minHeap.peek() + maxHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}
​
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
