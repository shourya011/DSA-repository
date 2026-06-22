
class MyCircularDeque {
    class Node{
        int val;
        Node next;
        Node prev;

        Node () {};

        Node(int val){
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int capacity;
    int size;
    public MyCircularDeque(int k) {
        head = null;
        tail = null;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        Node newN = new Node(value);
        if(isEmpty()){
            head = newN;
            tail = newN;
            size++;
            return true;
        }
        head.prev = newN;
        newN.next = head;
        head = newN;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        Node newN = new Node(value);
        if(isEmpty()){
            head = newN;
            tail = newN;
            size++;
            return true;
        }
        tail.next = newN;
        newN.prev = tail;
        tail = newN;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        if(size==1){
            head = null;
            tail = null;
            size--;
            return true;
        }
        head = head.next;
        head.prev = null;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(size==1){
            head = null;
            tail = null;
            size--;
            return true;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return head.val;
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return tail.val;
    }
    
    public boolean isEmpty() {
        if(head==null){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(size==capacity){
            return true;
        }
        return false;
    }
}
