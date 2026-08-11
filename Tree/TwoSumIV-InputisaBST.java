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
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return false;
        q.offer(root);
        int i = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            int check = k - temp.val;
            if(map.containsKey(check)){
                return true;
            }
            if(temp.left!=null) q.offer(temp.left);
            if(temp.right!=null) q.offer(temp.right);
            map.put(temp.val,i++);
        }
        return false;
    }
}


//653. Two Sum IV - Input is a BST