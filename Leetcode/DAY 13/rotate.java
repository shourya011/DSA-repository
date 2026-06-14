class rotata{
    public ListNode rotateRight(ListNode head, int k) {
        // if(head==null || head.next==null || k==0){
        //     return head;
        // }
        // int count = 0;
        // ListNode temp = head;
        // while(temp!=null){
        //     count++;
        //     temp = temp.next;
        // }
        // k = k % count;
        // for(int i=0;i<k;i++){
        //     ListNode p = head;
        //     ListNode q = null;
        //     while(p.next!=null){
        //     q = p;
        //     p = p.next;
        //     }
        // p.next = head;
        // q.next = null;
        // head = p;
        // }
        // return head;

            // Find the length n.
            // Compute k = k % n.
            // Find the (n - k)th node (new tail) and the (n - k + 1)th node (new head).
            // Break the link and connect the old tail to the old head.

        if(head==null || head.next==null || k==0){
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        k = k % count;
        if(k==0){
            return head;
        }
        int index = count - k;
        ListNode p = head;
        ListNode q = null;
        ListNode tail = head;
        for(int i=0;i<index;i++){
            q = p;
            p = p.next;
        }
        while(tail.next!=null){
            tail = tail.next;

        }
        tail.next = head;
        head = p;
        q.next = null;
        return head;
    }
    }
}
