class LevelOrderTraversal{
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        q.offer(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=1;i<=lvl;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                sublist.add(q.poll().val);
            }
            list.add(sublist);
        }
        return list;
    }
}