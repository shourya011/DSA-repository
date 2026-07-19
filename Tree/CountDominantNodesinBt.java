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
    public int countDominantNodes(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            for(int i=1;i<=lvl;i++){
                TreeNode temp = q.poll();
                int n = Integer.MIN_VALUE;
                int m = Integer.MIN_VALUE;
                if(temp.left!=null){
                    m = getMax(temp.left);
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    n = getMax(temp.right);
                    q.offer(temp.right);
                }
                if(temp.val>=m && temp.val>=n){
                    count++;
                }
            }
        }
        return count;
    }
    public int getMax(TreeNode node){
        if(node==null) return Integer.MIN_VALUE;
        int leftMax = getMax(node.left);
        int rigthMax = getMax(node.right);
        int temp = Math.max(leftMax,rigthMax);
        return Math.max(node.val,temp);
    }
}