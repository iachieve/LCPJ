// Runtime: 42 ms, faster than 98.26% of Java online submissions for Find Median from Data Stream.
// Memory Usage: 50.5 MB, less than 9.11% of Java online submissions for Find Median from Data Stream.

class MedianFinder {

    PriorityQueue<Integer> greatersMin = new PriorityQueue<>();
    PriorityQueue<Integer> lowersMax = new PriorityQueue<>(Collections.reverseOrder());
    double median = 0;
    
    public void addNum(int num) {
       if(lowersMax.size() == 0 || num < lowersMax.peek()){
           lowersMax.offer(num);
       }else{
           greatersMin.offer(num);
       }
        rebalanceHeaps();
    }
    
    private void rebalanceHeaps(){
        if(lowersMax.size() - greatersMin.size() == 2){
            greatersMin.offer(lowersMax.poll());
        }else if(greatersMin.size() - lowersMax.size() == 2){
            lowersMax.offer(greatersMin.poll());
        }
    }

    
    public double findMedian() {
          if(lowersMax.size() == greatersMin.size()){
            return (lowersMax.peek() + greatersMin.peek()) / 2.0;
        }else if(lowersMax.size() > greatersMin.size()){
            return lowersMax.peek();
        }else{
            return greatersMin.peek();
        }
    }
}
  
// solution 2
// Runtime: 55 ms, faster than 37.93% of Java online submissions for Find Median from Data Stream.
// Memory Usage: 50.6 MB, less than 9.11% of Java online submissions for Find Median from Data Stream.
class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // heap is a minimal heap by default
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // change to a maximum heap
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()) 
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) 
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}


















