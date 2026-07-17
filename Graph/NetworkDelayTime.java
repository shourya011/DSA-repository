class Solution {
    class Pair{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] time = new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: times){
            int u = i[0];
            int v = i[1];
            int w = i[2];
            adj.get(u).add(new int[]{v,w});
        }
        for(int i=0;i<=n;i++){
            time[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        q.offer(new Pair(k,0));
        time[k] = 0;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int no = temp.node;
            int dist = temp.distance;
            for(int[] i: adj.get(no)){
                int edgeWeight = i[1];
                int adjnode = i[0];
                if(dist + edgeWeight<time[adjnode]){
                    time[adjnode] = dist + edgeWeight;
                    q.offer(new Pair(adjnode,time[adjnode]));
                }
            }
        }
        int max = time[1];
        for(int i=1;i<time.length;i++){
            if(time[i]==Integer.MAX_VALUE){
                return -1;
            }
            if(max<time[i]){
                max = time[i];
            }
        }
        return max;
    }
}