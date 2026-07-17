class Solution {
    class Pair{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: edges){
            int u = i[0];
            int v = i[1];
            int wt = i[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        int[] dis = new int[V];
        for(int i=0;i<V;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        q.offer(new Pair(src,0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int dist = temp.distance;
            int n = temp.node;
            for(int[] i : adj.get(n)){
                int adjnode = i[0];
                int edgeWeight = i[1];
                if(dist + edgeWeight < dis[adjnode]){
                    dis[adjnode] = dist + edgeWeight;
                    q.offer(new Pair(adjnode,dis[adjnode]));
                }
            }
        }
        return dis;
        
    }
}