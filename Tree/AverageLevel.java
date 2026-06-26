class AverageLevel{
   public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        if(root==null) return list;
        q.offer(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            double temp = 0;
            for(int i=1;i<=lvl;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                temp += (q.poll().val);
            }
            list.add(temp/lvl);
        }
        return list;
    }
}