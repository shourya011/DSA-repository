   /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p==root || q==root){
            return root;
        }
        TreeNode t1 = lowestCommonAncestor(root.left,p,q);
        TreeNode t2 = lowestCommonAncestor(root.right,p,q);
        // if((t1==p && t2==q) ||(t1==q && t2==p)){
        //     return root;
        // }
        if(t1!=null && t2!=null){
            return root;
        }
        if(t1!=null){
            return t1;
        }
        return t2;
    }
}