class BrowserHistory {

    class Node{
        String val;
        Node next;
        Node prev;

        Node(){}

        Node(String val){
            this.val = val;
            next = null;
            prev = null;
        }
    }
    Node head,tail,curr;

    public BrowserHistory(String homepage) {
        Node newN = new Node(homepage);
        head = newN;
        tail = newN;
        curr = newN;
    }
    
    public void visit(String url) {
        Node newN = new Node(url);
        newN.prev = curr;
        curr.next = newN;
        tail = newN;
        curr = newN;
    }
    
    public String back(int steps) {
        for(int i=1;i<=steps ;i++){
            if(curr.prev == null){
                return curr.val;
            }
            curr = curr.prev;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        for(int i=1;i<=steps;i++){
            if(curr.next == null){
                return curr.val;
            }
            curr = curr.next;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */