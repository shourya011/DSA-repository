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
class SumRootToLeaf {
    ArrayList<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        String s = "";
        helper(root,s,list);
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }
    public void helper(TreeNode root,String s,ArrayList<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            s = s + root.val;
            int temp = Integer.parseInt(s);
            list.add(temp);
        }
        s = s + root.val;
        helper(root.left,s,list);
        helper(root.right,s,list);
    }
}