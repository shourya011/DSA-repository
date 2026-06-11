
class evenodd {
    public ListNode oddEvenList(ListNode head) {
        ListNode tem = head;
        int count = 0;
        while(tem!=null){
            tem = tem.next;
            count++;
        }
        ListNode even = new ListNode(-1);
        ListNode p = even;
        ListNode odd = new ListNode(-1);
        ListNode q = odd;
        ListNode temp = head;
        for(int i=1;i<=count;i++){
            ListNode t = temp.next;
            if(i%2!=0){
                q.next = temp;
                temp.next = null;
                q = temp;
            }
            else{
                p.next = temp;
                temp.next = null;
                p = temp;
            }
            temp = t;
        }
        q.next = even.next;
        return odd.next;
    }
}