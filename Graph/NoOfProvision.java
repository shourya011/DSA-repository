//no of connected components

class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here

        //converting edges to adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {                           
            adj.add(new ArrayList<>());
        }
                                                                //[
                                                                    // [],   // node 0
                                                                    // [],   // node 1
                                                                    // [],   // node 2
                                                                    // []    // node 3
                                                                //]

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);   // because the graph is undirected
        }

        //end
        boolean vis[] = new boolean[adj.size()];
        int count = 0;
        for(int i=0;i<adj.size();i++){
            if(!vis[i]){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
        
    }
    void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[node] = true;
        for(int i: adj.get(node)){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
        
    }
}