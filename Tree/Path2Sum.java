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
class Path2Sum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        List<Integer> t1 = new ArrayList<>();
        path(root,targetSum,list,t1);
        return list;
    }
    public void path(TreeNode root,int target,List<List<Integer>> list,List<Integer> t1){
        if(root==null) return;
        t1.add(root.val);
        target = target - root.val;
        if(root.left==null && root.right==null){
            if(target==0){
                list.add(new ArrayList<>(t1));
            }
            t1.remove(t1.size()-1);
            return;
        }
        path(root.left,target,list,t1);
        path(root.right,target,list,t1);
        t1.remove(t1.size()-1);
    }
    
}