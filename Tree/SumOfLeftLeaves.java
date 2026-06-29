class SumOfLeftLeaves{
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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        leftc(root.left);
        rightc(root.right);
        return sum;
    }
    public void leftc(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null)
            sum = sum + root.val;
        leftc(root.left);
        rightc(root.right);
    }
    public void rightc(TreeNode root){
        if(root==null) return;
        leftc(root.left);
        rightc(root.right);
    }
}
}