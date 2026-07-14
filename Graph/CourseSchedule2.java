
// DFS
// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
//         for(int i=0;i<numCourses;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<prerequisites.length;i++){
//             int u = prerequisites[i][0];
//             int v = prerequisites[i][1];
//             adj.get(v).add(u);
//         }
//         Stack<Integer> s = new Stack<>();
//         int[] vis = new int[numCourses];
//         boolean check = false;
//         for(int i=0;i<numCourses;i++){           /// main loop of topological
//             if(vis[i]==0){
//                 if(dfs(i,adj,vis,s)) return new int[]{};
//             }
//         }
//         int[] list = new int[numCourses];
//         for(int i=0;i<numCourses && !s.isEmpty();i++){
//             list[i] = s.pop();
//         }
//         return list;
//     }
//      public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,Stack<Integer> s){
//         vis[node] = 1;
//         for(int i: adj.get(node)){
//             if(vis[i]==1){
//                 return true;
//             }
//             if(vis[i]==0){
//                 if(dfs(i,adj,vis,s)) return true;;
//             }
//         }
//         s.push(node);
//         vis[node]=2;
//         return false;
//     }
// }



class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        if(i!=numCourses){
            return new int[]{};
        }
        return ans;
    }
}


//210