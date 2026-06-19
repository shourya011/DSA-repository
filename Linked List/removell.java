class removell{
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        ListNode q = dummy;
        if(p.val!=val){
            q.next = p;
        }
        while(p!=null){
            if(p.val==val){
                q.next = p.next;
            }
            if(p.val!=val)
                q = p;
            p = p.next;
        }
        return dummy.next;
    }
}