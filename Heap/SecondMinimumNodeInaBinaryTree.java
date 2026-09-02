/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {
//     PriorityQueue<Integer> q;
//     public int findSecondMinimumValue(TreeNode root) {
//         q = new PriorityQueue<>(Collections.reverseOrder());
//         inorder(root);
//         if(q.size()<2){
//             return -1;
//         }
//         int a = q.poll();
//         int b = q.poll();
//         if(a==b) return -1;
//         return a;
//     }
//     public void inorder(TreeNode root){
//         if(root==null) return;
//         inorder(root.left);
//         if(!q.contains(root.val))
//             q.offer(root.val);
//         if(q.size()>2){
//             q.poll();
//         }
//         inorder(root.right);
//     }
// }

class Solution {
    long min = Long.MAX_VALUE;
    long smin = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        inorder1(root);
        inorder2(root);
        if(smin == Long.MAX_VALUE){
            return -1;
        }
        return (int)smin;
    }
    public void inorder1(TreeNode root){
        if(root==null) return;
        inorder1(root.left);
        min = Math.min(min,root.val);
        inorder1(root.right);
    }
    public void inorder2(TreeNode root){
        if(root==null) return;
        inorder2(root.left);
        if(root.val!=min){
            smin = Math.min(smin,root.val);
        }
        inorder2(root.right);
    }

}

//671. Second Minimum Node In a Binary Tree