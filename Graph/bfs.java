class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];  //when start from 0 only this else n+1
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            
            for(int i:adj.get(node)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.offer(i);
                }
            }
        }
        return bfs;
    }
}