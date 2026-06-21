class PreOrder{

    //recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = preOrder(root,list);
        return list;
    }
    public List<Integer> preOrder(TreeNode root,List<Integer> list){
        if(root==null) return list;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
        return list;
    }


    //iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null) return list;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.right!=null) s.push(node.right);  //right
            if(node.left!=null) s.push(node.left);      //left
            list.add(node.val);
        }
        return list;
    }
}