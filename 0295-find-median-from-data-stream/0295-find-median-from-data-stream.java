class MedianFinder {

    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;
    public MedianFinder() {
        minHeap  = new PriorityQueue<>();
        maxHeap  = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
         maxHeap.add(num);
         if(!minHeap.isEmpty() && maxHeap.size() - minHeap.size() == 1){
             if(maxHeap.peek() > minHeap.peek()){
                 int t = maxHeap.poll();
                 maxHeap.add(minHeap.poll());
                 minHeap.add(t);
             }
         }else if(maxHeap.size() - minHeap.size() > 1){
             minHeap.add(maxHeap.poll());
         }
    }
    
    public double findMedian() {
        int total = maxHeap.size() + minHeap.size();
        if(total % 2 == 0) return (1.0 *(maxHeap.peek() + minHeap.peek())) / 2;
        else return 1.0 * maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 /***
  */