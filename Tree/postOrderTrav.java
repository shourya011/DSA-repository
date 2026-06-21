class postOrderTrav {
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     postOrder(root,list);
    //     return list;
    // }
    // public void postOrder(TreeNode root,List<Integer> list){
    //     if(root==null){
    //         return;
    //     }
    //     postOrder(root.left,list);
    //     postOrder(root.right,list);
    //     list.add(root.val);
    // }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if(root==null) return list;
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);
            if(node.left!=null) s1.push(node.left);
            if(node.right!=null) s1.push(node.right);
        }
        while(!s2.isEmpty()){
            int value = s2.peek().val;
            s2.pop();
            list.add(value);
        }
        return list;
    }
}