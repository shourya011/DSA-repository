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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode t1 = head;
        while(t1!=null){
            list.add(t1.val);
            t1 = t1.next;
        }
        int[] arr = {-1,-1};
        ArrayList<Integer> set = new ArrayList<>();
        for(int i=1;i<list.size()-1;i++){
            int t2 = crict(list,i);
            if(t2!=-1){
                set.add(i);
            }
        }
        if(set.size()<2){
            return arr;
        }
        int max = set.get(set.size()-1) - set.get(0);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<set.size();i++){
            int curr = set.get(i) - set.get(i-1);
            if(curr<min){
                min = curr;
            } 
        }
        arr[0] = min;
        arr[1] = max;
        return arr;
    }
    public int crict(ArrayList<Integer> list,int index){
        if(list.get(index-1)>list.get(index) && list.get(index+1)>list.get(index)){
            return list.get(index);
        }
        if(list.get(index-1)<list.get(index) && list.get(index+1)<list.get(index)){
            return list.get(index);
        }
        return -1;
    }
}


//2058. Find the Minimum and Maximum Number of Nodes Between Critical Points