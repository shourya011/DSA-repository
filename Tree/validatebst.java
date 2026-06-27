class validatebst{
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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean l = leftcheck(root.left,Long.MIN_VALUE,root.val);
        boolean r = rightcheck(root.right,root.val,Long.MAX_VALUE);
        return l && r;
    }
    public boolean leftcheck(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        if(!((min<root.val)&&(root.val<max))){
            return false;
        }
        boolean l = leftcheck(root.left,min,root.val);
        boolean r = rightcheck(root.right,root.val,max);
        return l && r;
    }
    public boolean rightcheck(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        if(!((min<root.val) && (root.val<max))){
            return false;
        }
        boolean l = leftcheck(root.left,min,root.val);
        boolean r = rightcheck(root.right,root.val,max);
        return l && r;
    }
}