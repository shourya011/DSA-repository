class minDepth{
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int l = 0;
        int r = 0;
        if(root.right==null)
            return 1+ minDepth(root.left);
        if(root.left==null)
            return 1 + minDepth(root.right);
        if(root.left!=null && root.right!=null){
            l = minDepth(root.left);
            r = minDepth(root.right);
        }
        return 1 + Math.min(l,r);
    }
}