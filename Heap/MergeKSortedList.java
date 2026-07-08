class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                q.offer(temp);
                temp = temp.next;
            }
        }
        ListNode d = new ListNode(-1);
        ListNode curr = d;
        while(!q.isEmpty()){
            ListNode temp = q.poll();
            curr.next = temp;
            curr = temp;
            curr.next = null;
        }
        return d.next;
    }
}



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                q.offer(lists[i]);
        }
        ListNode d = new ListNode(-1);
        ListNode curr = d;
        while(!q.isEmpty()){
            ListNode temp = q.poll();
            ListNode temp2 = temp.next;
            ListNode newN = new ListNode(temp.val);
            if(temp2!=null)
                q.offer(temp2);
            curr.next = newN;
            curr = newN;
        }
        return d.next;

    }
}