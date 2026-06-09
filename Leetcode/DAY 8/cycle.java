class cycle{
    public static boolean cycle(ListNode head,int pos){
        if(head==null || head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            if(fast.next!=null)
                fast = fast.next.next;
            else{
                fast = fast.next;
            }
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}