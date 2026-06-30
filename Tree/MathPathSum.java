class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int temp = sum(root);
        return maxSum;
    }
    public int sum(TreeNode root){
        if(root==null) return 0;
        int l = Math.max(0,sum(root.left));
        int r = Math.max(0,sum(root.right));
        maxSum = Math.max(maxSum,l+r+root.val);
        return root.val + Math.max(l,r);
    }
}