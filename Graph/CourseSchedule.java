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

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }
        int[] indegree = new int[numCourses];        //the no of incoming edges
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        if(ans.size()==numCourses){
            return true;
        }
        return false;
    }
}

//207