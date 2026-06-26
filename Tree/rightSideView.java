class rightSideView{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return list;
        q.offer(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            for(int i=1;i<=lvl;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                TreeNode temp = q.poll();
                if(lvl==i){
                    list.add(temp.val);
                }
            }
        }
        return list;
    }
}