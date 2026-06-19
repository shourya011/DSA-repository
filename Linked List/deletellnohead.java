class deletellnohead{
    public void deleteNode(ListNode node) {

        // ListNode p = node;
        // ListNode q = node;
        // ListNode main = node;
        // while(p.next!=null){
        //     if(p.next!=null)
        //         q = p.next;
        //     int temp = p.val;
        //     p.val = q.val;
        //     q.val = temp;
        //     main = p;
        //     p = p.next;
        // }
        // main.next =null;

        ListNode p = node.next;
        int temp = node.val;
        node.val= p.val;
        p.val = temp;
        node.next = p.next;

    }
}