class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: edges){
            int[] vis = new int[edges.length+1];
            int u = i[0];
            int v = i[1];
            if(dfs(u,v,adj,edges,vis)){
                return new int[]{u,v};
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{};
    }
    public boolean dfs(int curr,int target,ArrayList<ArrayList<Integer>> adj,int[][] edges,int[] vis){
        vis[curr] = 1;
        if(curr==target){
            return true;
        }
        for(int i : adj.get(curr)){
            if(vis[i]==0){
                if(dfs(i,target,adj,edges,vis)==true)
                    return true;
            }
        }
        return false;
    }
}