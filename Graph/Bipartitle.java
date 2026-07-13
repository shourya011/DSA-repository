class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        for(int i=0;i<color.length;i++){
            color[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.offer(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int x=0;x<graph[node].length;x++){
                        int temp = graph[node][x];
                        if(color[temp]==-1){
                            if(color[node]==0){
                                color[temp] = 1;
                            }
                            if(color[node]==1){
                                color[temp] = 0;
                            }
                            q.offer(temp);
                        }
                        if(color[node]==color[temp]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}




// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         Queue<Integer> q = new LinkedList<>();
//         int[] color = new int[graph.length];
//         for(int i=0;i<color.length;i++){
//             color[i] = -1;
//         }
//         for (int i = 0; i < graph.length; i++) {
//             if (color[i] == -1) {
//                 if(dfs(i,0,color,graph)==false) return false;
//             }   
//         }
//         return true;
//     }
//     public boolean dfs(int node,int col,int[] color,int[][] graph){
//         color[node] = col;
//         for(int i=0;i<graph[node].length;i++){
//             int temp = graph[node][i];
//             if(color[temp]==-1){
//                 if(dfs(temp,1-col,color,graph)==false) return false;
//             }
//             else if(color[temp]==col){
//                 return false;
//             }
//         }
//         return true;
//     }
// }