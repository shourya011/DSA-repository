class removenthlast{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        int dif = count - n;
        ListNode p = head;
        ListNode q = head;
        if(dif==0){
            return head.next;
        }
        for(int i=0;i<dif;i++){
            q = p;
            p = p.next;
        }
        q.next = p.next;
        return head;
    }
}