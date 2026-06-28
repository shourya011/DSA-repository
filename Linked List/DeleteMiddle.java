class DeleteMiddle{
    // public ListNode deleteMiddle(ListNode head) {
    //     ListNode temp = head;
    //     int c = 0;
    //     while(temp!=null){
    //         c++;
    //         temp = temp.next;
    //     }
    //     if(head.next==null && c==1){
    //         return null;
    //     }
    //     ListNode p = head;
    //     for(int i=1;i<c/2;i++){
    //         p = p.next;
    //     }
    //     if(p.next!=null)
    //         p.next = p.next.next;
        
    //     return head;
    // }



    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = null;
        if(slow.next==null){
            return null;
        }
        while(fast!=null && fast.next!=null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = slow.next;
        return head;
    }


}