class LowestCommonAncestor{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        TreeNode temp = null;
        if(p.val<root.val && q.val<root.val)
            temp = lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val && q.val>root.val)
            temp = lowestCommonAncestor(root.right,p,q);
        else{
            return root;
        }
        return temp;
    }
}