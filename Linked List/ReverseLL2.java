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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode l=head,r=head;
        ListNode prevLeft=d,nextRight=null;
        for(int i=1;i<left;i++){
            prevLeft = l;
            l = l.next;
        }
        for(int j=1;j<right;j++){
            r = r.next;
        }
        nextRight = r.next;
        ListNode c = l;
        ListNode p = null;
        ListNode f = l.next;
        while(c!=nextRight){
            f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        prevLeft.next = r;
        l.next = nextRight;
        return d.next;

    }
}