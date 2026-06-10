class merge2list{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(p!=null && q!=null){
            if(p.val<q.val){
                curr.next = p;
                curr = p;
                p = p.next;
            }
            else{
                curr.next = q;
                curr = q;
                q = q.next;
            }
        }
        if(q!=null){
            curr.next = q;
        }
        else{
            curr.next = p;
        }
        return dummy.next;
    }
}