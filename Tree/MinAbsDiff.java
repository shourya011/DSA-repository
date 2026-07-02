  //Same for the 783. Minimum Distance Between BST Nodes
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
class MinAbsDiff{
    ArrayList<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        int min = Integer.MAX_VALUE;
        inorder(root);
        // for(int i=0;i<list.size();i++){
        //     for(int j=i+1;j<list.size();j++){
        //         int n = list.get(i)-list.get(j);
        //         if(min>Math.abs(n)){
        //             min = Math.abs(n);
        //         }
        //     }
        // }

        for(int i=1;i<list.size();i++){
            int ans = list.get(i-1) - list.get(i);
            if(min>Math.abs(ans)){
                min = Math.abs(ans);
            }
        }
        return min;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}