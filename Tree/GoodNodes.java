class GoodNodes{
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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        helper(root,root.val);
        return count;
    }
    public void helper(TreeNode root,int max){
        if(root==null) return;
        if(root.val>=max){
            count++;
            helper(root.left,root.val);
            helper(root.right,root.val);
        }
        else{
            helper(root.left,max);
            helper(root.right,max);
        }
    }
}
}