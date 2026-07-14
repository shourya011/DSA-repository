class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<graph.length;i++){
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            //i -> it
            //it -> i
            for(int j=0;j<graph[i].length;j++){
                int temp = graph[i][j];
                adjRev.get(temp).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            list.add(temp);
            for(int it: adjRev.get(temp)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}