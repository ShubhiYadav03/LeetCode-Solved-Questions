class StockSpanner {
    Stack< Pair <Integer, Integer>> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        while(!st.isEmpty() && st.peek().getKey()<=price){
            count+=st.pop().getValue();
        }
        st.push(new Pair(price,count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */