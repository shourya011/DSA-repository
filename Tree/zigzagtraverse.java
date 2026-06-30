class zigzagtraverse{
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return list;
        int count = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            count++;
            List<Integer> sublist = new ArrayList<>();
            for(int i=1;i<=lvl;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                sublist.add(q.poll().val);
            }
            if(count%2==0){
                Collections.reverse(sublist);
            }
            list.add(sublist);
        }
        return list;
    }
}
}


2 stack method

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> t1 = new ArrayList<>();
            List<Integer> t2 = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode n = s1.pop();
                t1.add(n.val);
                if(n.left!=null) s2.push(n.left);
                if(n.right!=null) s2.push(n.right);
            }
            while(!s2.isEmpty()){
                TreeNode n = s2.pop();
                t2.add(n.val);
                if(n.right!=null) s1.push(n.right);
                if(n.left!=null) s1.push(n.left);
            }
            if(!t1.isEmpty())
                list.add(t1);
            if(!t2.isEmpty())
                list.add(t2);
        }
        return list;
    }
}