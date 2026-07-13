class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        q.offer(source);
        vis[source] = 1;
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp==destination){
                return true;
            }
            for(int i:adj.get(temp)){
                if(vis[i]==0){
                    q.offer(i);
                    vis[i] = 1;
                }
            }
        }
        return false;
    }
}