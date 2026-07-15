class Solution {
    int countConnected(int[][] isConnected) {
        // code here

        //converting edges to adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {                           
            adj.add(new ArrayList<>());
        }
                                                                //[
                                                                    // [],   // node 0
                                                                    // [],   // node 1
                                                                    // [],   // node 2
                                                                    // []    // node 3
                                                                //]

        for(int i=0;i<isConnected.length;i++){
	        for(int j=0;j<isConnected[0].length;j++){
		        if(isConnected[i][j]==1 && i!=j){
			        adj.get(i).add(j);
		        }
	        }
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