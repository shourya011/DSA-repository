class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean check = false;
        for(int i=0;i<V;i++){
            if(vis[i]==0)
                if(dfs(i,-1,adj,vis))
                    return true;
        }
        return false;
    }
    public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node] = 1;
        for(int i: adj.get(node)){
            if(vis[i]==1 && i!=parent){ // undirected graph means that i!=parent and remove it when in directed graph
                return true;
            }
            if(vis[i]==0){
                if(dfs(i,node,adj,vis)==true)
                    return true;
            }
        }
        vis[node] = 2;
        return false;
    }
}

//gfg
//0 means unvisited
//1 means visiting
//2 means visted
