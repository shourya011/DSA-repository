/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }

        ListNode temp = prev;
        ListNode max = temp;
        ListNode t1 = temp.next;
        while(t1!=null){
            if(t1.val>=max.val){
                max = t1;
                t1 = t1.next;
            }
            else{
                max.next = t1.next;
                t1 = max.next;
            }
        }
        ListNode c = temp;
        ListNode p= null;
        while(c!=null){
            ListNode f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        return p;

    }
}