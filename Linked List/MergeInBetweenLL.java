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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1;
        ListNode q = list1;
        for(int i=0;i<a-1;i++){
            p = p.next;
        }
        for(int i=0;i<=b;i++){
            q = q.next;
        }
        p.next = list2;
        ListNode temp = list2;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = q;
        return list1;
    }
}

//1669. Merge In Between Linked Lists