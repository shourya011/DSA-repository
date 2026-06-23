class StockSpan{
    Stack<int[]> s;
    public StockSpan() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int[] arr = new int[2];
        int span = 1;
        while(!s.isEmpty() && s.peek()[0]<=price){
            span += s.peek()[1];
            s.pop();
        }
        s.push(new int[]{price,span});
        return span;
    }
}