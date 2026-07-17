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
    public ListNode doubleIt(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode f = curr.next;
            curr.next = prev;
            prev = curr;
            curr = f;
        }
        int carry = 0;
        ListNode temp = prev;
        ListNode p = null;
        while(temp!=null){
            p = temp;
            int x = temp.val*2 + carry;
            temp.val = (temp.val * 2 + carry)%10;
            if(x<10){
                carry = 0;
            }
            else {
                carry = 1;
            }
            temp = temp.next;
        }
        if(carry==1){
            ListNode newN = new ListNode(1);
            p.next = newN;
        }
        ListNode pr = null;
        ListNode c = prev;
        while(c!=null){
            ListNode f = c.next;
            c.next = pr;
            pr = c;
            c = f;
        }
        return pr;
    }
}