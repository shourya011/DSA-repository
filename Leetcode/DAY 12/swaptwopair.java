class swaptwopair{
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode d = new ListNode(-1);
        ListNode curr = d;
        while(p!=null && p.next!=null){
            q = p.next;
            ListNode temp = q.next;
            curr.next = q;
            q.next = p;
            p.next = temp;
            curr = p;
            p = temp;
        }
        curr.next = p;
        return d.next;
    }
}