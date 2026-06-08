class deletemiddlell{
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head.next==null){
            return null;
        }
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        Node p = head;
        Node q = p.next;
        for(int i=1;i<count/2;i++){
            p = p.next;
            if(q.next!=null)
                q = p.next;
        }
        if(q.next==null){
            p.next=null;
        }
        p.next = q.next;
        return head;
    }
}