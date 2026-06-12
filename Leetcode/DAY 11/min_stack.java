class min_stack{
    Stack<Integer> s;
    Stack<Integer> min;
    public SpecialStack() {
         s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        if(min.isEmpty()){
        min.push(x);
       }
       else{
        int val = min.peek();
        if(val<x){
            min.push(val);
        }
        else{
            min.push(x);
        }
       }
       s.push(x);
    }

    public void pop() {
        // Remove the top element from the Stack
        
        if(!s.isEmpty()){
         s.pop();
        min.pop();
        }
    }

    public int peek() {
        // Returns top element of the Stack
        if(s.isEmpty())
            return -1;
        return s.peek();
    }

    boolean isEmpty() {
        // Check if the stack is empty
        return s.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
        if(min.isEmpty())
            return -1;
        return min.peek();
    }
}
