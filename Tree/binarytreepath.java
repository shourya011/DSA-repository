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



//gfg
class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sublist = new ArrayList<>();
        if(root==null) return list;
        helper(root,list,sublist);
        return list;
    }
    public void helper(Node root,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> sublist){
        if(root==null) return;
        sublist.add(root.data);
        if(root.left==null && root.right==null){
            list.add(new ArrayList<>(sublist));
            sublist.remove(sublist.size()-1); //backtracking
            return;
        }
        helper(root.left,list,sublist);
        helper(root.right,list,sublist);
        sublist.remove(sublist.size()-1); //backtracking
    }
}


// list.add(sublist) → saves the original notebook.
// list.add(new ArrayList<>(sublist)) → saves a photocopy of the current page.