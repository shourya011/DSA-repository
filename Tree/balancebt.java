class balancebt{
    //O(N^2)
    // public boolean isBalanced(TreeNode root) {
    //     if(root==null) return true;
    //     int left = maxheight(root.left);
    //     int right = maxheight(root.right);

    //     if(Math.abs(left-right)>1) return false;

    //     boolean leftroot = isBalanced(root.left);
    //     boolean rightroot = isBalanced(root.right);

    //     if(!leftroot || !rightroot){
    //         return false;
    //     }
    //     return true;
    // }
    // public int maxheight(TreeNode root){
    //     if(root==null){
    //         return 0;
    //     }
    //     int left = maxheight(root.left);
    //     int right = maxheight(root.right);
    //     return 1 + Math.max(left,right);
    // }

    //0(N)
    public boolean isBalanced(TreeNode root) {
        return maxheight(root) != -1;
    }
    public int maxheight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = maxheight(root.left);
        if(left==-1){
            return -1;
        }
        int right = maxheight(root.right);
        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1) return -1;

        return 1 + Math.max(left,right);
    }

}