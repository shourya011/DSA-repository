class diameter{
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        height(root);
        return maxDiameter;
    }
    public int height(TreeNode root) {
        if(root==null) return 0;
        int leftc = height(root.left);
        int rightc = height(root.right);
        maxDiameter = Math.max(maxDiameter,leftc+rightc);
        return 1 + Math.max(leftc,rightc);
    }
}