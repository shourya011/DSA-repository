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
class InsertionBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newN = new TreeNode(val);
        if(root==null){
            root = newN;
            return root;
        }
        if(root.left==null && root.right==null){
            if(root.val<val){
                root.right = newN;
                return root;
            }
            if(root.val>val){
                root.left = newN;
                return root;
            }
        }
        if(root.left==null){
            if(root.val>val){
                root.left= newN;
                return root;
            }
        }
        if(root.right==null){
            if(root.val<val){
                root.right=newN;
                return root;
            }
        }
        if(root.val<val){
            TreeNode r = insertIntoBST(root.right,val);
        }
        if(root.val>val){
            TreeNode l = insertIntoBST(root.left,val);
        }
        return root;
    }
}