class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        TreeNode l = null;
        TreeNode r =null;
        if(val==root.val){
            return root;
        }
        if(val<root.val)
            l = searchBST(root.left,val);
        if(val>root.val)
            r = searchBST(root.right,val);
        if(l!=null){
            return l;
        }
        return r;
    }
}