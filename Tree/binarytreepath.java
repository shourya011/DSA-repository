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
class binarytreepath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null) return list;
        String path = "";
        helper(root,path,list);
        return list;
    }
    public void helper(TreeNode root,String path,List<String> list){
        if(root==null) return;
        if(path.isEmpty()){
            path = ""+ root.val;
        }
        else
            path = path + "->" + root.val;
        if(root.right==null && root.left==null){
           list.add(path);
           return;
        }
        helper(root.left,path,list);
        helper(root.right,path,list);
    }
}
