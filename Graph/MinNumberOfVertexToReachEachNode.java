class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
        }
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}

//1557