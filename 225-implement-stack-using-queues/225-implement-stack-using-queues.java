class MyStack {
    Queue<Integer> q=new ArrayDeque<>();

    public MyStack() {
         q=new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        reverse(q);
        int temp=q.poll();
        reverse(q);
        return temp;
    }
    
    public int top() {
        reverse(q);
        int temp=q.peek();
        reverse(q);
        return temp;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
    
    private void reverse(Queue<Integer> q){
        if(q.isEmpty()) return;
        int temp=q.poll();
        reverse(q);
        q.add(temp);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */