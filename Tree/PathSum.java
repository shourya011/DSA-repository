class PathSum{
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        targetSum -= root.val;
        if(root.left==null && root.right==null){
            if(targetSum==0){
                return true;
            }
        }
        boolean leftc = hasPathSum(root.left,targetSum);
        boolean rightc = hasPathSum(root.right,targetSum);
        return leftc || rightc;
    }

    
}