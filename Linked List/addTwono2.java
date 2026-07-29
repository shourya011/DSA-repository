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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode p1 = null;
        while(c1!=null){
            ListNode f1 = c1.next;
            c1.next = p1;
            p1 = c1;
            c1 = f1;
        }
        ListNode c2 = l2;
        ListNode p2 = null;
        while(c2!=null){
            ListNode f2 = c2.next;
            c2.next = p2;
            p2 = c2;
            c2 = f2;
        }
        ListNode t1 = p1;
        ListNode t2 = p2;
        int carry = 0;
        ListNode d = new ListNode(-1);
        ListNode curr = d;
        while(t1!=null && t2!=null){
            int sum = t1.val + t2.val + carry;
            if(sum>=10){
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newN = new ListNode(sum%10);
            curr.next = newN;
            curr = newN;
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1!=null){
            int sum = t1.val + carry;
            if(sum>=10){
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newN = new ListNode(sum%10);
            curr.next = newN;
            curr = newN;
            t1 = t1.next;
        }
        while(t2!=null){
            int sum = t2.val + carry;
            if(sum>=10){
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newN = new ListNode(sum%10);
            curr.next = newN;
            curr = newN;
            t2 = t2.next;
        }
        if(carry==1){
            ListNode newN = new ListNode(1);
            curr.next = newN;
            curr = newN;
        }

        ListNode c3 = d.next;
        ListNode p3 = null;
        while(c3!=null){
            ListNode f3 = c3.next;
            c3.next = p3;
            p3 = c3;
            c3 = f3;
        }
        return p3;
    }
}


//445. Add Two Numbers II
