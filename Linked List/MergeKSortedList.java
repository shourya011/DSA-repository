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
// class MergeKSortedList {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists==null) return null;
//         ArrayList<Integer> arr = new ArrayList<>();
//         ListNode d = new ListNode(-1);
//         ListNode curr = d;
//         for(int i=0;i<lists.length;i++){
//             ListNode temp = lists[i];
//             while(temp!=null){
//                 arr.add(temp.val);
//                 temp = temp.next;
//             }
//         }
//         Collections.sort(arr);
//         for(int i=0;i<arr.size();i++){
//             ListNode newN = new ListNode(arr.get(i));
//             curr.next = newN;
//             curr = newN;
//         }
//         return d.next;
//     }
// }




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