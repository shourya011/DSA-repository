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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> du = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        ListNode t = head;
        while(t!=null){
            if(set.contains(t.val) || du.contains(t.val)){
                set.remove(t.val);
                du.add(t.val);
                t = t.next;
                continue;
            }
            set.add(t.val);
            t = t.next;
        }
        int[] s = new int[set.size()];
        int i = 0;
        for(int x : set){
            s[i++] = x;
        }
        Arrays.sort(s);
        ListNode d = new ListNode(-1);
        ListNode curr = d;
        for(int p=0;p<s.length;p++){
            ListNode newN = new ListNode(s[p]);
            curr.next = newN;
            curr = newN;
        }   
        return d.next;
    }
}

//82. Remove Duplicates from Sorted List II