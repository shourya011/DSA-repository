//Actually its day 7

class middlell{
    int getMiddle(Node head) {
        // code here
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int val = 0;
        for(int i=0;i<=count/2;i++){
            val = head.data;
            head = head.next;
        }
        return val;
    }
}