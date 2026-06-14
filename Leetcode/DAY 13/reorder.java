class reorder{
public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode p = head;
        while(p!=null && p.next!=null && p.next.next != null){
            ListNode q = p;
            ListNode d = null;
            while(q.next!=null ){
                d = q;
                q = q.next;
            }
            ListNode temp = p.next;
            d.next = null;
            p.next = q;
            q.next = temp;
            p = temp;
        }
    }
}