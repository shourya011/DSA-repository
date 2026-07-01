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
class FlatternBTtoLL {
    ArrayList<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return;
        preorder(root);
        TreeNode d = new TreeNode(-1);
        TreeNode c = d;
        for(int i=0;i<list.size();i++){
            TreeNode n = list.get(i);
            n.left = null;
            c.right = n;
            c = n;
        }
    }
    public void preorder(TreeNode root){
        if(root==null) return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}