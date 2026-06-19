class Intersectll{
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // ListNode p = headA;
        // while(p!=null){
        //     ListNode q = headB;
        //     while(q!=null){
        //         if(p==q){
        //             return p;
        //         }
        //         q = q.next;
        //     }

        //     p = p.next;
        // }
        // return null;
    // }
    

    public int length(Node head){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        int l1 = length(head1);
        int l2 = length(head2);
        int dif = 0;
        if(l1>l2){
            dif = l1-l2;
            for(int i=0;i<dif;i++){
                head1 = head1.next;
            }
        }
        else{
            dif = l2-l1;
            for(int i=0;i<dif;i++){
                head2 = head2.next;
            }
        }
        Node p = head1;
        Node q = head2;
        while(p!=null){
            if(p==q){
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}