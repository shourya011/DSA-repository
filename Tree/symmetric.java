class symmetric{
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode node1 = root.left;
        TreeNode node2 = root.right;
        boolean ans = mirror(node1,node2);
        return ans;
    }
    public boolean mirror(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        boolean l = mirror(node1.left,node2.right);
        boolean r = mirror(node1.right,node2.left);
        return l && r;
    }
}