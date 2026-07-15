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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head,last = head;
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        for(int i=1;i<k;i++){
            first = first.next;
        }
        for(int i=1;i<=count-k;i++){
            last = last.next;
        }
        int temp1 = first.val;
        first.val = last.val;
        last.val = temp1;
        return head;


    }
}