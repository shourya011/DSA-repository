class MyLinkedList {
    Node head = null;
    int length;
    class Node{
        int val;
        Node next;
        
        public Node(){}

        public Node(int val){
            this.val = val;
            next = null;
        }
    }
    public int get(int index) {
        if(index<0 || index>=length){
            return -1;
        }
        Node temp = head;
        for(int i=1;i<=index;i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newN = new Node(val);
        if(head==null){
            head = newN;
            length++;
            return;
        }
        newN.next = head;
        head = newN;
        length++;
    }
    
    public void addAtTail(int val) {
        Node newN = new Node(val);
        if(head==null){
            head = newN;
            length++;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newN;
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        Node temp = head;
        Node newN = new Node(val);
        if(index>length || index<0){
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }
        else if(index==length){
            addAtTail(val);
            return;
        }
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        newN.next = temp.next;
        temp.next = newN;
        length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=length){
            return;
        }
        if(index==0){
            head = head.next;
            length--;
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        length--;
    }
}