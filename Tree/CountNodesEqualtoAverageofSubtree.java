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
class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null) return 0;
        int n = helper(root);
        return count;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int sum = l + r + root.val;
        int n = noofnodes(root);
        int avg = sum / n;
        if(avg==root.val) count++;
        return sum;
    }
    public int noofnodes(TreeNode root){
        if(root==null) return 0;
        return noofnodes(root.left) + noofnodes(root.right) + 1;
    }
}

//2265. Count Nodes Equal to Average of Subtree