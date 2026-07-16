class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        for(int i=0;i<rooms.get(0).size();i++){
            dfs(0,rooms,vis);
        }
        for(int i=0;i<rooms.size();i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
    public void dfs(int node,List<List<Integer>> rooms,boolean[] vis){
        vis[node] = true;
        for(int i: rooms.get(node)){
            if(!vis[i]){
                dfs(i,rooms,vis);
            }
        }
    }
}