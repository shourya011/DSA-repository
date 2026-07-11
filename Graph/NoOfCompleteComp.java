class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                boolean check = true;
                ArrayList<Integer> com = new ArrayList<>();
                dfs(i,adj,vis,com);
                int k = com.size();
                for(int j: com){
                    if(adj.get(j).size() != k-1){
                        check = false;
                    }
                }
                if(check){
                    count++;
                }
            }
        } 
        return count; 
        
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer> com){
        vis[node] = true;
        com.add(node);
        for(int i: adj.get(node)){
            if(!vis[i]){
                dfs(i,adj,vis,com);
            }
        }

    }
}