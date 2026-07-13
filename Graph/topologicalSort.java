class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[V];
        for(int i=0;i<V;i++){           /// main loop of topological
            if(vis[i]==0){
                dfs(i,adj,vis,s);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.isEmpty()){
            list.add(s.pop());
        }
        return list;
        
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,Stack<Integer> s){
        vis[node] = 1;
        for(int i: adj.get(node)){
            if(vis[i]==0){
                dfs(i,adj,vis,s);
            }
        }
        s.push(node);
    }
}