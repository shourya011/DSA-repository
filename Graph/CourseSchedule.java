// DFS
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
//         int[] vis = new int[numCourses];  //0 unvisted. //1 visting //2visted
//         for(int i=0;i<numCourses;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<prerequisites.length;i++){
//             int u = prerequisites[i][0];
//             int v = prerequisites[i][1];

//             adj.get(v).add(u);
//         }
//         for(int i=0;i<numCourses;i++){
//             if(vis[i]==0){
//                 if(dfs(i,vis,adj)==true) return false;
//             }
//         }
//         return true;
//     }
//     public boolean dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj){
//         vis[node] = 1;
//         for(int i:adj.get(node)){
//             if(vis[i]==1){
//                 return true;
//             }
//             if(vis[i]==0){
//                 if(dfs(i,vis,adj)) return true;
//             }
//         }
//         vis[node] = 2;
//         return false;
//     }
// }




//207