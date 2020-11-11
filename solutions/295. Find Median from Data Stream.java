class MedianFinder {
    PriorityQueue<Integer> lowersMax = new PriorityQueue<>(Collections.reverseOrder());
​
    PriorityQueue<Integer> greatersMin = new PriorityQueue<>();
    
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
​
