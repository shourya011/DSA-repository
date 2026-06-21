class Inorder{
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     inOrder(root,list);
    //     return list;
    // }
    // public void inOrder(TreeNode root,List<Integer> list){
    //     if(root==null){
    //         return;
    //     }
    //     inOrder(root.left,list);
    //     list.add(root.val);
    //     inOrder(root.right,list);
    // }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null) return list;
        TreeNode node = root;
        while(true){
            if(node!=null){
                s.push(node);
                node = node.left;
            }
            else{
                if(s.isEmpty()){
                    break;
                }
                node = s.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}