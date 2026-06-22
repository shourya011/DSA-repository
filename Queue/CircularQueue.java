class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;
    public MyCircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
        return false;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } 
        else
            rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(size==1){
            front = -1;
            rear = -1;
        }
        else{
             front = (front + 1) % capacity;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(front==-1 && rear==-1){
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