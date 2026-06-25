class SameTree{
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     Stack<TreeNode> s1 = new Stack<>();
    //     Stack<TreeNode> s2 = new Stack<>();
    //     if(p==null && q==null) return true; //imp
    //     if(p==null || q== null) return false; //imp
    //     s1.push(p);
    //     s2.push(q);
    //     while(!s1.isEmpty() && !s2.isEmpty()){
    //         TreeNode t1 = s1.pop();
    //         TreeNode t2 = s2.pop();
    //         if((t1.left == null) != (t2.left == null))      //imp
    //             return false;
    //         if((t1.right == null) != (t2.right == null)) // imp
    //             return false;
    //         if(t1.right!=null && t2.right!=null){
    //             s1.push(t1.right);
    //             s2.push(t2.right);
    //         }
    //         if(t1.left!=null && t2.left!=null){
    //             s1.push(t1.left);
    //             s2.push(t2.left);
    //         }
    //         if(t1.val != t2.val). //easy
    //             return false;
    //     }
    //     return true;
    // }


    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p==null && q==null){
        return true;
       }
       if(p==null || q==null){
        return false;
       }
       boolean ans = (p.val==q.val);
       boolean leftSame = isSameTree(p.left,q.left);
       boolean rightSame = isSameTree(p.right,q.right);
       return leftSame && rightSame && ans;
    }
}