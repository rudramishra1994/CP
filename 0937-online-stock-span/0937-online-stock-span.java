class StockSpanner {

    private Stack<int[]> mono;
    public StockSpanner() {
        mono = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!mono.isEmpty() && mono.peek()[0] <= price){
            span += mono.pop()[1];
        }
        mono.push(new int []{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */