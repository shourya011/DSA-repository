class reversell{

    // public ListNode reverseList(ListNode head) {
    //     ListNode p = head;
    //     while(p!=null){
    //         ListNode q = p.next;
    //         while(q!=null){
    //             int temp = p.val;
    //             p.val = q.val;
    //             q.val = temp;
    //             q = q.next;
    //         }
    //         p = p.next;
    //     }
    //     return head;
    // }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = null;
        ListNode c = head;
        ListNode f = head.next;
        c.next = null;
        while(c!=null){
            ListNode temp = null;
            if(f!=null){
                temp = f.next;
                f.next = c;
            }
            p = c;
            c = f;
            if(f!=null)
                f = temp;
        }
        return p;
    }

}