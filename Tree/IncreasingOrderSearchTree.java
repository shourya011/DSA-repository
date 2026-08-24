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
    ArrayList<Integer> arr = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode d = new TreeNode(arr.get(0));
        TreeNode curr = d;
        for(int i=1;i<arr.size();i++){
            TreeNode newN = new TreeNode(arr.get(i));
            curr.right = newN;
            curr = newN;
        }
        return d;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
}

//897. Increasing Order Search Tree