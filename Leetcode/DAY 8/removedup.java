class removedup{
    public static ListNode removedup(ListNode head){
        public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        while(p!=null && q!=null){
            if(p.val==q.val){
             p.next = q.next;
            }
            else{
                p = q;
            }
            q = q.next;
        }
        return head;
    }
    }
}