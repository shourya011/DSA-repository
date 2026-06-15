class addtwono{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while(p!=null || q!=null){
            int sum = 0;
            if(q!=null && p==null)
                sum = q.val + carry;
            else if(q==null && p!=null){
                sum  = p.val + carry;
            }
            else{
                sum = p.val + q.val + carry;
            }
            if(sum>=10){
                sum = sum %10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newN = new ListNode(sum);
            curr.next = newN;
            curr = newN;
            if(p!=null)
                 p = p.next;
            if(q!=null)
            q = q.next;
        }
        if(carry==1){
            ListNode newN = new ListNode(1);
            curr.next = newN;
        }
        return dummy.next;
    }
}