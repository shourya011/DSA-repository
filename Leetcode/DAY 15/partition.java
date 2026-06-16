class partition{
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode s = small;
        ListNode l = large;
        ListNode temp = head;
        while(temp!=null){
            ListNode t = temp.next;
            if(temp.val<x){
                s.next = temp;
                s = temp;
            }
            else{
                l.next = temp;
                l = temp;
            }
            temp = t;
        }
        s.next = large.next;
        l.next = null;
        return small.next;
    }
}