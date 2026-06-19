class QueueusingStack{
    class MyQueue {
    Stack<Integer> s;
    Stack<Integer> temp;
    public MyQueue() {
        s =  new Stack<>();
        temp =  new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    public int pop() {
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        int val = temp.pop();
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
        return val;
    }
    
    public int peek() {
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        int val = temp.peek();
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
        return val;
    }
    
    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}