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
    public ListNode mergeNodes(ListNode head) {
        ListNode d = new ListNode(-1);
        int sum = 0;
        ListNode curr = d;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val==0){
                if(sum!=0){
                    ListNode newN = new ListNode(sum);
                    curr.next = newN;
                    curr = newN;
                }
                sum = 0;
            }
            sum += temp.val;
            temp = temp.next;
        }
        return d.next;
    }
}


//2181. Merge Nodes in Between Zeros
