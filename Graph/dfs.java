class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        vis[0] = true;
        dfs(0,adj,vis,list);
        return list;
        
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer> list){
        vis[node] = true;
        list.add(node);
        for(int i: adj.get(node)){
            if(!vis[i]){
                dfs(i,adj,vis,list);
            }
        }
        
    }
}